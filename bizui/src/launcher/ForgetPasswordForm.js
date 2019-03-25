import React, { Component } from 'react';
import { Form, Icon, Input, Button, Checkbox, Alert, message } from 'antd';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link, Route, Redirect, Switch } from 'dva/router';
import LauncherService from './Launcher.service';
import { notification } from 'antd';
import { Layout } from 'antd';
import styles from './LoginForm.less';
import Result from '../components/Result';

import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

const { Content, Footer } = Layout;

const FormItem = Form.Item;

const FormItemLayout = {
  labelCol: { span: 0 },
  wrapperCol: { span: 24 },
};

class NormalForgetPassword extends Component {
  state = {
    currentStep: 'start', //start, inputvcode, changepass
    currentValues: {},
  };

  handleSubmit = e => {
    e.preventDefault();

    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
        const dispatch = this.props.dispatch;
        dispatch({ type: 'launcher/login', payload: { ...values } });
      }
    });
  };

  getNextStep(currentStep) {
    if (currentStep === 'start') {
      return 'inputvcode';
    }
    if (currentStep === 'inputvcode') {
      return 'changepass';
    }
    if (currentStep === 'changepass') {
      return 'finish';
    }
  }

  executeAction(currentStep, currentValues) {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;

    if (currentStep == 'start') {
      const future = LauncherService.getVerificationCode(currentValues.mobile);
      future.then(result => {
        console.log('the result is ', result);
        if (result == 'USER_NOT_FOUNT' || result == 'USER_NOT_FOUNT') {
          notification.error({
            message: `${launcherLocaleName(userContext, 'ThisPhoneNumber')}${
              currentValues.mobile
            }${launcherLocaleName(userContext, 'CouldNotFindUser')}, ${launcherLocaleName(
              userContext,
              'PleaseContractAdmin'
            )}`,
            description: `${launcherLocaleName(userContext, 'ThisPhoneNumber')}${
              currentValues.mobile
            }${launcherLocaleName(userContext, 'CouldNotFindUser')}, ${launcherLocaleName(
              userContext,
              'PleaseContractAdmin'
            )}`,
          });
          return;
        }
        const nextStep = this.getNextStep(currentStep);
        this.setState({ currentValues, currentStep: nextStep });
      });
    }
    if (currentStep == 'inputvcode') {
      const nextStep = this.getNextStep(currentStep);
      this.setState({ currentValues, currentStep: nextStep });
    }
    if (currentStep == 'changepass') {
      const mobile = currentValues.mobile;
      const verificationCode = currentValues.verificationCode;
      const password = currentValues.password;
      const confirmPassword = currentValues.confirmPassword;

      if (password != confirmPassword) {
        notification.error({
          message: launcherLocaleName(userContext, 'PasswordsDontMatch'),
          description: launcherLocaleName(userContext, 'Passworddoesnotmatch'),
        });
        return;
      }

      const future = LauncherService.forgetPasswordWithConfirm(
        mobile,
        verificationCode,
        password,
        confirmPassword
      );
      future.then(result => {
        console.log('the result is ', result);

        if (result == 'VERIFIICATION_CODE_NOT_MATCH') {
          notification.error({
            message: launcherLocaleName(userContext, 'VerificationCodeError'),
            description: launcherLocaleName(userContext, 'VerificationCodeError'),
          });
          return;
        }

        const nextStep = this.getNextStep(currentStep);
        this.setState({ currentValues, currentStep: nextStep });
      });
    }
  }
  //console.log(future);

  gotoNextStep = e => {
    e.preventDefault();

    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
        const dispatch = this.props.dispatch;
        const oldValues = this.state.currentValues;
        const currentValues = { ...oldValues, ...values };
        const currentStep = this.state.currentStep;
        this.executeAction(currentStep, currentValues);

        //dispatch({type:"launcher/login", payload:{...values} });
      }
    });
  };

  inputMobileForm = () => {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;
    const { getFieldDecorator } = this.props.form;
    return (
      <Form onSubmit={this.gotoNextStep}>
        <FormItem {...FormItemLayout}>
          {getFieldDecorator('mobile', {
            rules: [
              { required: true, message: launcherLocaleName(userContext, 'InputPhoneNumber') },
            ],
          })(
            <Input
              prefix={<Icon type="user" style={{ fontSize: 20 }} />}
              placeholder={launcherLocaleName(userContext, 'MobilePhone')}
            />
          )}
        </FormItem>
        <Button
          type="primary"
          htmlType="submit"
          className="login-form-button"
          style={{ width: '100%' }}
        >
          {launcherLocaleName(userContext, 'NextStep')}
        </Button>
        <Link to="/" style={{ float: 'right' }}>
          {launcherLocaleName(userContext, 'ReturnToHome')}
        </Link>
      </Form>
    );
  };

  inputVerficationCodeForm = () => {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;
    const { getFieldDecorator } = this.props.form;
    return (
      <Form onSubmit={this.gotoNextStep}>
        <FormItem {...FormItemLayout}>
          {getFieldDecorator('verificationCode', {
            rules: [
              {
                required: true,
                message: launcherLocaleName(userContext, 'PleaseInputVerificationCode'),
              },
            ],
          })(
            <Input
              prefix={<Icon type="lock" style={{ fontSize: 20 }} />}
              placeholder={launcherLocaleName(userContext, 'VerificationCode')}
            />
          )}
        </FormItem>
        <FormItem>
          <Button
            type="primary"
            htmlType="submit"
            className="login-form-button"
            style={{ width: '100%' }}
          >
            {launcherLocaleName(userContext, 'NextStep')}
          </Button>
        </FormItem>{' '}
        <FormItem>
          <Link to="/" style={{ float: 'right' }}>
            {launcherLocaleName(userContext, 'ReturnToHome')}
          </Link>{' '}
        </FormItem>
      </Form>
    );
  };

  successForm = () => {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;

    return (
      <Result
        type="success"
        title={launcherLocaleName(userContext, 'ChangedSuccess')}
        description={
          <Link to="/" style={{ float: 'right' }}>
            {launcherLocaleName(userContext, 'ReturnToHome')}
          </Link>
        }
        style={{ marginTop: 48, marginBottom: 16 }}
      />
    );
  };
  inputPasswordForm = () => {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;
    const { getFieldDecorator } = this.props.form;
    return (
      <Form onSubmit={this.gotoNextStep}>
        <FormItem {...FormItemLayout}>
          {getFieldDecorator('password', {
            rules: [
              {
                required: true,
                message: launcherLocaleName(userContext, 'PleaseInputYourPassword'),
              },
            ],
          })(
            <Input
              prefix={<Icon type="lock" style={{ fontSize: 20 }} />}
              type="password"
              placeholder={launcherLocaleName(userContext, 'Password')}
            />
          )}
        </FormItem>
        <FormItem {...FormItemLayout}>
          {getFieldDecorator('confirmPassword', {
            rules: [
              { required: true, message: launcherLocaleName(userContext, 'PleaseInputNewPass') },
            ],
          })(
            <Input
              prefix={<Icon type="lock" style={{ fontSize: 20 }} />}
              type="password"
              placeholder={launcherLocaleName(userContext, 'PleaseInputPass')}
            />
          )}
        </FormItem>
        <Button
          type="primary"
          htmlType="submit"
          className="login-form-button"
          style={{ width: '100%' }}
        >
          {launcherLocaleName(userContext, 'ChangePassword')}
        </Button>
        <Link to="/" style={{ float: 'right' }}>
          {launcherLocaleName(userContext, 'ReturnToHome')}
        </Link>
      </Form>
    );
  };

  showForm = () => {
    const { currentStep } = this.state;

    if (currentStep === 'start') {
      return this.inputMobileForm();
    }

    if (currentStep === 'inputvcode') {
      return this.inputVerficationCodeForm();
    }

    if (currentStep === 'changepass') {
      return this.inputPasswordForm();
    }

    return this.successForm();
  };

  render() {
    if (!this.props.launcher) {
      return null;
    }

    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;

    //console.log("what the type",getFieldDecorator );
    return (
      <div className={styles.login}>
        <div className={styles.loginForm}>
          <div className={styles.loginLogo}>
            <span>{launcherLocaleName(userContext, 'ForgetPassword')}</span>
          </div>

          {this.showForm()}
        </div>
      </div>
    );
  }
}

const ForgetPasswordForm = Form.create()(NormalForgetPassword);

const mapStateToProps = state => {
  return state;
};
const mapDispatchToProps = dispatch => ({
  receiveData: bindActionCreators({}, dispatch),
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(ForgetPasswordForm);
