package com.yaolaizai.ylzx.baseproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yaolaizai.ylzx.baseproject.MainActivity;
import com.yaolaizai.ylzx.baseproject.R;
import com.yaolaizai.ylzx.baseproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {


    @BindView(R.id.et_lgn_user)
    EditText etLgnUser;
    @BindView(R.id.et_lgn_pwd)
    EditText etLgnPwd;
    @BindView(R.id.btn_lgn)
    Button btnLgn;

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initData() {


    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getUserName() {
        return etLgnUser.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etLgnPwd.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        etLgnUser.setText("");

    }

    @Override
    public void clearPassword() {
        etLgnPwd.setText("");
    }

    @Override
    public void toMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showFailedError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toPassWroad() {
//        startActivity(new Intent(LoginActivity.this, ForgetPassActivity.class));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.btn_lgn)
    public void onClick() {
        presenter.login();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
