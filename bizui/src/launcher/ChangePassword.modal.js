import {
  Row,
  Col,
  Card,
  Form,
  Input,
  Select,
  Icon,
  Button,
  Dropdown,
  Menu,
  InputNumber,
  DatePicker,
  Modal,
  message,
  Alert,
} from 'antd';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link, Route, Redirect, Switch } from 'dva/router';
import LauncherService from './Launcher.service';
import { notification } from 'antd';
import { Layout } from 'antd';
import styles from './LoginForm.less';
import Result from '../components/Result';
import { Component } from 'react';
import modeltool from '../utils/modeltool';

import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

const {
  setupModel,
  hasError,
  handleClientError,
  handleServerError,
  keepValueWithKeySuffix,
} = modeltool;

const ChangePassword = targetComponent => {
  const { hideModal } = targetComponent.props;
  console.log('trying to change password', ChangePassword);
  console.log('see to hideModal', hideModal);

  targetComponent.props.form.validateFields((err, values) => {
    if (!err) {
      console.log('Received values of form: ', values);

      if (values.confirmPassword != values.newPassword) {
        notification.error({
          message: launcherLocaleName(userContext, 'InputError'),
          description: launcherLocaleName(userContext, 'Passwordsdonotmatch'),
        });
        return;
      }

      const future = LauncherService.ChangePassword(values);
      future.then(result => {
        console.log('the result is ', result);
        if (result == 'OK') {
          hideModal();
          notification.success({
            message: launcherLocaleName(userContext, 'Success'),
            description: launcherLocaleName(userContext, 'UseYourNewPasswordtoSignIn'),
          });
        }
        if (hasError(result)) {
          handleServerError(result);
          return;
        }
      });

      //dispatch({type:"launcher/login", payload:{...values} });
    }
  });
};

const formItemLayout = {
  labelCol: { span: 10 },
  wrapperCol: { span: 14 },
};

class ChangePasswordModel extends Component {
  render() {
    if (!this.props.launcher) {
      return null;
    }
    const userContext = this.props.launcher.data;
    const { getFieldDecorator } = this.props.form;

    const { visible, hideModal } = this.props;

    return (
      <Modal
        title={launcherLocaleName(userContext, 'ChangePassword')}
        visible={visible}
        onOk={() => ChangePassword(this)}
        onCancel={event => hideModal(event)}
        width={620}
        style={{ top: 40 }}
      >
        <Form>
          <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
            <Col lg={24} md={24} sm={24}>
              <Form.Item label={launcherLocaleName(userContext, 'OldPassword')} {...formItemLayout}>
                {getFieldDecorator('currentPassword', {
                  rules: [
                    {
                      required: true,
                      message: launcherLocaleName(userContext, 'PleaseInputOldPass'),
                    },
                  ],
                })(
                  <Input
                    placeholder={launcherLocaleName(userContext, 'PleaseInputYourPassword')}
                    type="password"
                    prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  />
                )}
              </Form.Item>
              <Form.Item label={launcherLocaleName(userContext, 'NewPassword')} {...formItemLayout}>
                {getFieldDecorator('newPassword', {
                  rules: [
                    {
                      required: true,
                      message: launcherLocaleName(userContext, 'InputNewPassword'),
                    },
                  ],
                })(
                  <Input
                    placeholder={launcherLocaleName(userContext, 'PleaseInputYourPassword')}
                    type="password"
                    prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  />
                )}
              </Form.Item>
              <Form.Item
                label={launcherLocaleName(userContext, 'PleaseInputPassAgain')}
                {...formItemLayout}
              >
                {getFieldDecorator('confirmPassword', {
                  rules: [
                    {
                      required: true,
                      message: launcherLocaleName(userContext, 'PleaseInputNewPass'),
                    },
                  ],
                })(
                  <Input
                    placeholder={launcherLocaleName(userContext, 'PleaseInputYourPassword')}
                    type="password"
                    prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  />
                )}
              </Form.Item>
            </Col>
          </Row>
        </Form>
      </Modal>
    );
  }
}

const ChangePasswordModelForm = Form.create()(ChangePasswordModel);

const mapStateToProps = state => {
  return state;
};
const mapDispatchToProps = dispatch => ({
  receiveData: bindActionCreators({}, dispatch),
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(ChangePasswordModelForm);
