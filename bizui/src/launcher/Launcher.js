import FontAwesome from 'react-fontawesome';
import { Row, Col, Card, Table, Popconfirm, Button } from 'antd';

import React from 'react';
import { Link } from 'react-router';
import TopMenu from './TopMenu';

//import BizRouter from './BizRouter'

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Layout } from 'antd';


import HomeScreen from './HomeScreen.js'
import LoginForm from './LoginForm.js'
import  './LoginForm.less'
const { Content, Footer } = Layout;

class Launcher extends React.Component {

    componentDidMount(){

        const { dispatch} = this.props;
        

        dispatch({ type: 'launcher/home'});
        

    }
    

    render() {
        const state = this.props.launcher;

        console.log(this.props);
        console.log("state is",state)

        if(state&&state.loggedIn){

            return (<Layout style={ {height:'100%'}}>
                    <Content style={ {overflow: 'initial', height:'100%'}}>
                    <HomeScreen/>
                    </Content>
                
              </Layout>);
        }

        return (<Layout style={ {height:'100%'}}>
                    <Content style={{ textAlign: "center",overflow: 'initial', height:'100%' }}>
                    <LoginForm/>
                    </Content>
                
              </Layout>
        )

    }
}


const mapStateToProps = state => {   
    return state;
};
const mapDispatchToProps = dispatch => ({
    receiveData: bindActionCreators({}, dispatch)
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(Launcher);

