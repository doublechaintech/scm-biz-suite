import React, { Component } from 'react';
import { Form, Icon, Input, Button, Checkbox,Alert,message } from 'antd';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { Link, Route, Redirect, Switch } from 'dva/router'

import { Layout } from 'antd';
import styles  from './LoginForm.less'
const { Content, Footer } = Layout;

const FormItem = Form.Item;

class NormalLoginForm extends Component {
    handleSubmit = (e) => {
        e.preventDefault();
        
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                const dispatch = this.props.dispatch;
                const username = values.username;
                const password = values.password;
                
                dispatch({type:"launcher/login", payload:{...values} });
            }
        });



    };
    render() {
        const { getFieldDecorator } = this.props.form;
        const { systemName }=this.props.launcher;
        const {data} = this.props.launcher
        //console.log("what the type",getFieldDecorator );
        return (
           
    <div className={styles.login}>
                <div className={styles.loginForm} >
                    <div className={styles.loginLogo}>
                        <span>{systemName}</span>
                    </div>
                   
            <Form onSubmit={this.handleSubmit} >
                <FormItem>
                    {getFieldDecorator('username', {
                        rules: [{ required: true, message: '请输入用户名!' }],
                    })(
                        <Input prefix={<Icon type="user" />} placeholder="用户名" />
                    )}
                </FormItem>
                <FormItem>
                    {getFieldDecorator('password', {
                        rules: [{ required: true, message: '请输入密码!' }],
                    })(
                        <Input prefix={<Icon type="lock" />} type="password" placeholder="密码" />
                    )}
                </FormItem>
                <FormItem>
                <Link className="login-form-forgot" to="/forgetpass" style={{float: 'right'}}>忘记密码</Link>
                   
                    <Button type="primary" htmlType="submit" className="login-form-button" style={{width: '100%'}}>
                        登录
                    </Button>
                    
                </FormItem>
            </Form>
            </div></div>
        );
    }
}

const LoginForm = Form.create()(NormalLoginForm);

const mapStateToProps = state => {   
    return state;
};
const mapDispatchToProps = dispatch => ({
    receiveData: bindActionCreators({}, dispatch)
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(LoginForm);



