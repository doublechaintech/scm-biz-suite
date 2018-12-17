import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';


import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link, Route, Redirect, Switch } from 'dva/router'
import LauncherService from './Launcher.service'
import { notification } from 'antd'
import { Layout } from 'antd';
import styles  from './LoginForm.less'
import Result from '../components/Result'
import { Component } from 'react';
import modeltool from '../utils/modeltool'
const {setupModel,hasError,handleClientError,handleServerError,keepValueWithKeySuffix}=modeltool

const  changePassword=(targetComponent)=>{

  const {hideModal} = targetComponent.props
  console.log("trying to change password", changePassword)
  console.log("see to hideModal", hideModal)

  targetComponent.props.form.validateFields((err, values) => {
    if (!err) {
        console.log('Received values of form: ', values);

        if(values.confirmPassword!=values.newPassword){

          notification.error({
            message: "输入错误",
            description: "两次输入的密码不一致",
          })
          return
        }
        
        const future = LauncherService.changePassword(values)
         future.then(result => {
            console.log("the result is ",result)
            if(result=="OK"){
             
              hideModal()
              notification.success({
                message: "执行成功",
                description: "修改密码成功，请使用您的新密码",
              })
            }
            if(hasError(result)){
              handleServerError(result)
              return
            }

            
           
         })

        //dispatch({type:"launcher/login", payload:{...values} });
    }
  });

}





const formItemLayout = {
  labelCol: { span: 10 },
  wrapperCol: { span: 14 },
}


class ChangePasswordModel extends Component{



 

  render() {


      const { getFieldDecorator } = this.props.form
     
      const {visible,hideModal} = this.props


      return (<Modal
        title="更新密码"
        visible={visible}
        onOk={() => changePassword(this)}
        onCancel={(event) => hideModal(event)}
        width={620}
        style={{ top: 40 }}
      >
          <Form >
          <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
           <Col lg={24} md={24} sm={24}>
                <Form.Item label={"原密码"} {...formItemLayout}>
                  {getFieldDecorator('currentPassword', {
                   
                    rules: [{ required: true, message: '请输入旧密码' }],
                  })(
                    <Input placeholder="请输入密码" type="password" prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                    
                  )}
                </Form.Item>
                <Form.Item label={"新密码"} {...formItemLayout}>
                  {getFieldDecorator('newPassword', {
                   
                    rules: [{ required: true, message: '请输入新密码' }],
                  })(
                    <Input placeholder="请输入密码" type="password" prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                    
                  )}
                </Form.Item>
                <Form.Item label={"再次输入新密码"} {...formItemLayout}>
                  {getFieldDecorator('confirmPassword', {
                   
                    rules: [{ required: true, message: '请再次输入新密码' }],
                  })(
                    <Input placeholder="请输入密码" type="password" prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                    
                  )}
                </Form.Item>
              </Col>


          </Row>
          </Form>

       
      </Modal>)

    }


}


const ChangePasswordModelForm = Form.create()(ChangePasswordModel);

const mapStateToProps = state => {   
    return state;
};
const mapDispatchToProps = dispatch => ({
    receiveData: bindActionCreators({}, dispatch)
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(ChangePasswordModelForm);


