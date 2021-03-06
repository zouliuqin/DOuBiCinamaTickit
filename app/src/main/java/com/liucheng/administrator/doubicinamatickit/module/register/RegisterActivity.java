package com.liucheng.administrator.doubicinamatickit.module.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.util.PhoneNumberUtil;

import java.net.PasswordAuthentication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tv_include_login_title)
    TextView tvIncludeLoginTitle;
    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;
    @BindView(R.id.et_register_username)
    EditText etRegisterUsername;
    @BindView(R.id.et_register_auth_code)
    EditText etRegisterAuthCode;
    @BindView(R.id.ib_register_auth_code)
    Button ibRegisterAuthCode;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.et_register_again_password)
    EditText etRegisterAgainPassword;
    @BindView(R.id.but_register)
    Button butRegister;


    //手机号
    String phoneNumber;

    //验证码
    String authCode;
    //密码
    String password;
    //确认密码
    String againPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.ib_include_back, R.id.ib_register_auth_code, R.id.but_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_include_back:
                finish();
                break;
            case R.id.ib_register_auth_code:
                phoneNumber = etRegisterUsername.getText().toString();
                //检查手机号格式
                boolean isMobile = PhoneNumberUtil.isMobile(phoneNumber);

                if (!isMobile) {
                    Toast.makeText(this, "请检查手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                //发送验证码
                BmobSMS.requestSMSCode(phoneNumber, "zouliuqin", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {
                        if (e == null) {//验证码发送成功
                            Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.but_register:
                phoneNumber = etRegisterUsername.getText().toString();

                authCode = etRegisterAuthCode.getText().toString();

                password = etRegisterPassword.getText().toString();

                againPassword = etRegisterAgainPassword.getText().toString();


                //点击注册按钮，先检查数据完整性，再检测验证码是否正确

                if (TextUtils.isEmpty(phoneNumber) ||
                        TextUtils.isEmpty(authCode) ||
                        TextUtils.isEmpty(password) ||
                        TextUtils.isEmpty(againPassword)) {
                    Toast.makeText(this, "请完整数据！", Toast.LENGTH_SHORT).show();
                    return;
                }


                //坚持密码和重复密码是否一致
                if (!password.equals(againPassword)) {
                    etRegisterAgainPassword.setTextColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(this, "两次密码不一致！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //检查验证码是否正确，调用Bmob方法
                BmobSMS.verifySmsCode(phoneNumber, authCode, new UpdateListener() {

                    @Override
                    public void done(BmobException ex) {
                        if (ex == null) {//短信验证码已验证成功
                            //注册
                            User bu = new User();
                            bu.setNickname(phoneNumber);
                            bu.setUsername(phoneNumber);
                            bu.setPassword(password);



                            //注意：不能用save方法进行注册
                            bu.signUp(new SaveListener<User>() {
                                @Override
                                public void done(User s, BmobException e) {
                                    if (e == null) {

                                    } else {

                                    }
                                }
                            });
                        } else {
                            Log.i("smile", "验证失败：code =" + ex.getErrorCode() + ",msg = " + ex.getLocalizedMessage());
                        }
                    }
                });
                break;
        }
    }
}
