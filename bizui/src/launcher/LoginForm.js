import React, { Component } from 'react';
import { Form, Icon, Input, Button, Checkbox, Alert, message } from 'antd';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { Link, Route, Redirect, Switch } from 'dva/router';

import { Layout } from 'antd';
import styles from './LoginForm.less';
const { Content, Footer } = Layout;
import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

const FormItem = Form.Item;

class NormalLoginForm extends Component {
  handleSubmit = e => {
    e.preventDefault();

    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
        const dispatch = this.props.dispatch;
        const username = values.username;
        const password = values.password;

        dispatch({ type: 'launcher/login', payload: { ...values } });
      }
    });
  };
  render() {
    const { getFieldDecorator } = this.props.form;

    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;
    const { systemName } = this.props.launcher;
    const { data } = this.props.launcher;
    if (!systemName) {
      return null;
    }
    //console.log("what the type",getFieldDecorator );
    return (
      <div className={styles.login}>
        <div className={styles.loginForm}>
          <div className={styles.loginLogo}>
            <span>{systemName}</span>
          </div>

          <Form onSubmit={this.handleSubmit}>
            <FormItem>
              {getFieldDecorator('username', {
                rules: [
                  {
                    required: true,
                    message: launcherLocaleName(userContext, 'PleaseInputUsername'),
                  },
                ],
              })(
                <Input
                  prefix={<Icon type="user" />}
                  placeholder={launcherLocaleName(userContext, 'Username')}
                />
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('password', {
                rules: [
                  {
                    required: true,
                    message: launcherLocaleName(userContext, 'PleaseInputYourPassword'),
                  },
                ],
              })(
                <Input
                  prefix={<Icon type="lock" />}
                  type="password"
                  placeholder={launcherLocaleName(userContext, 'Password')}
                />
              )}
            </FormItem>
            <FormItem>
              <Link className="login-form-forgot" to="/forgetpass" style={{ float: 'right' }}>
                {launcherLocaleName(userContext, 'ForgetPassword')}
              </Link>

              <Button
                type="primary"
                htmlType="submit"
                className="login-form-button"
                style={{ width: '60%' }}
              >
                {launcherLocaleName(userContext, 'LogIn')}
              </Button>
            </FormItem>
          </Form>
        </div>
      </div>
    );
  }
}

const LoginForm = Form.create()(NormalLoginForm);

const mapStateToProps = state => {
  return state;
};
const mapDispatchToProps = dispatch => ({
  receiveData: bindActionCreators({}, dispatch),
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(LoginForm);
