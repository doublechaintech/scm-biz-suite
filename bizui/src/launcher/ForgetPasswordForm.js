import React, { Component } from 'react';
import { Form, Icon, Input, Button, Checkbox,Alert,message } from 'antd';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Link, Route, Redirect, Switch } from 'dva/router'
import LauncherService from './Launcher.service'
import { notification } from 'antd'
import { Layout } from 'antd';
import styles  from './LoginForm.less'
import Result from '../components/Result'
const { Content, Footer } = Layout;

const FormItem = Form.Item;

const FormItemLayout = {
    labelCol: { span: 0 },
    wrapperCol: { span: 24 },
  }

class NormalForgetPassword extends Component {

    state = {
        currentStep: 'start', //start, inputvcode, changepass
        currentValues: {},
      };

    handleSubmit = (e) => {
        e.preventDefault();
        
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                const dispatch = this.props.dispatch;
                dispatch({type:"launcher/login", payload:{...values} });
            }
        });



    };

    getNextStep(currentStep){

        if(currentStep === "start"){
            return "inputvcode"
        }
        if(currentStep === "inputvcode"){
            return "changepass"
        }
        if(currentStep === "changepass"){
            return "finish"
        }
    }


    executeAction(currentStep,currentValues){
       
        if(currentStep=="start"){
            const future = LauncherService.getVerificationCode(currentValues.mobile)
            future.then(result => {
                console.log("the result is ",result)
                if(result=="USER_NOT_FOUNT"||result=="USER_NOT_FOUNT"){
                    notification.error({
                        message: `该手机号${currentValues.mobile}关联的用户找不到, 请联系管理员`,
                        description: `该手机号${currentValues.mobile}关联的用户找不到, 请联系管理员`,
                      });
                    return

                }
                const nextStep = this.getNextStep(currentStep)
                this.setState({currentValues,currentStep:nextStep})
            })
        }
        if(currentStep=="inputvcode"){
           
            const nextStep = this.getNextStep(currentStep)
            this.setState({currentValues,currentStep:nextStep})
        }
        if(currentStep=="changepass"){
            const mobile = currentValues.mobile
            const verificationCode = currentValues.verificationCode
            const password = currentValues.password
            const confirmPassword = currentValues.confirmPassword
            
            if(password!=confirmPassword){
                notification.error({
                    message: "密码输入不同",
                    description: "两次密码输入不同",
                  });
                return
            }


            const future = LauncherService.forgetPasswordWithConfirm(mobile,verificationCode,password,confirmPassword)
            future.then(result => {
                console.log("the result is ",result)

                if(result=="VERIFIICATION_CODE_NOT_MATCH"){
                    notification.error({
                        message: "验证码错误",
                        description: "验证码错误",
                      })
                      return
                }

                const nextStep = this.getNextStep(currentStep)
                this.setState({currentValues,currentStep:nextStep})
            })
        }
        
     
    }
    //console.log(future);

   


    gotoNextStep = (e) => {
        e.preventDefault();
        
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                const dispatch = this.props.dispatch;
                const oldValues = this.state.currentValues
                const currentValues={...oldValues,...values}
                const currentStep = this.state.currentStep
                this.executeAction(currentStep,currentValues)

                //dispatch({type:"launcher/login", payload:{...values} });
            }
        });



    };


    inputMobileForm = () => {
        const { getFieldDecorator } = this.props.form;
        return (<Form onSubmit={this.gotoNextStep} >
            <FormItem  {...FormItemLayout}>
                {getFieldDecorator('mobile', {
                    rules: [{ required: true, message: '请输入手机号!' }],
                })(
                    <Input prefix={<Icon type="user" style={{ fontSize: 20 }} />} placeholder="手机号" />
                )}
               
            </FormItem>
            <Button type="primary" htmlType="submit" className="login-form-button" style={{width: '100%'}}>
                    下一步
                    
                </Button><Link to="/" style={{float: 'right'}}>返回主页</Link>
        </Form>)
    }

    inputVerficationCodeForm = () => {
        const { getFieldDecorator } = this.props.form;
        return ( <Form onSubmit={this.gotoNextStep} >
            <FormItem  {...FormItemLayout}>
               {getFieldDecorator('verificationCode', {
                   rules: [{ required: true, message: '请输入验证码!' }],
               })(
                   <Input prefix={<Icon type="lock" style={{ fontSize: 20 }} />}  placeholder="验证码" />
               )}
           </FormItem> 
                   <FormItem>
                   <Button type="primary" htmlType="submit" className="login-form-button" style={{width: '100%'}}>
                       下一步
                       
                   </Button>
                   </FormItem> <FormItem>
                   <Link to="/" style={{float: 'right'}}>返回主页</Link> </FormItem>
                   
                   </Form>)

    }

    successForm = () => {
        return (<Result
        type="success"
        title="修改成功"
        description={<Link to="/" style={{float: 'right'}}>返回主页</Link>}
       
        style={{ marginTop: 48, marginBottom: 16 }}
      />)

    }
    inputPasswordForm = () => {
        const { getFieldDecorator } = this.props.form;
        return ( <Form onSubmit={this.gotoNextStep} >
            <FormItem  {...FormItemLayout}>
                {getFieldDecorator('password', {
                    rules: [{ required: true, message: '请输入密码!' }],
                })(
                    <Input prefix={<Icon type="lock" style={{ fontSize: 20 }} />}  type="password" placeholder="密码" />
                )}
            </FormItem> 
            <FormItem   {...FormItemLayout}>
                {getFieldDecorator('confirmPassword', {
                    rules: [{ required: true, message: '请重新输入密码!' }],
                })(
                    <Input prefix={<Icon type="lock" style={{ fontSize: 20 }} />}  type="password" placeholder="重新输入密码" />
                )}
            </FormItem>
            <Button type="primary" htmlType="submit" className="login-form-button" style={{width: '100%'}}>
                        修改密码
                    </Button>
                    <Link to="/" style={{float: 'right'}}>返回主页</Link>
            </Form>)

    }



    showForm = () =>{

       
        const {currentStep} = this.state

        if(currentStep === "start"){
            return this.inputMobileForm()
        }

        if(currentStep === "inputvcode"){
            return this.inputVerficationCodeForm()
        }

        if(currentStep === "changepass"){
            return this.inputPasswordForm()
        }

        return this.successForm()


    }


    render() {
       





        //console.log("what the type",getFieldDecorator );
        return (
           
    <div className={styles.login}>
                <div className={styles.loginForm} >
                    <div className={styles.loginLogo}>
                        <span>忘记密码</span>
                    </div>
                   
                    {this.showForm()}

            </div></div>
        );
    }
}

const ForgetPasswordForm = Form.create()(NormalForgetPassword);

const mapStateToProps = state => {   
    return state;
};
const mapDispatchToProps = dispatch => ({
    receiveData: bindActionCreators({}, dispatch)
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(ForgetPasswordForm);



