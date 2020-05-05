import { Menu, Icon } from 'antd';
import React from 'react';
import FontAwesome from 'react-fontawesome';
import { connect } from 'react-redux';

import {sessionObject} from '../utils/utils'


class SwitchAppMenu extends React.Component {
  


  gotoApp = (e,app) => {
    console.log('click ', app);
    const dispatch = this.props.dispatch;
    dispatch({ type: 'launcher/gotoApp', payload: { app } });
  };

  handleClick = e => {
    console.log('click ', e);
    const dispatch = this.props.dispatch;
  }


  render() {
    if(!this.props.launcher){
      return <div>正在载入</div>
    }
    if(!this.props.launcher.data){


      

       return <div>正在载入</div>
    }
    
    const {userAppList} = this.props.launcher.data;
    const targetApp = sessionObject('targetApp')
    const {id}=targetApp

    return (
      <Menu  theme="dark" mode={"inline"}>
        
       {userAppList.filter(item=>item.id!==id).map(app=>(
        
        <Menu.Item onClick={(e)=>this.gotoApp(e,app)}  key={app.title} >
         
          {app.title}
        </Menu.Item>

       ))}
       
        
      </Menu>
    );
  }
}
const mapStateToProps = state => {
  return state;
};

export default connect(mapStateToProps)(SwitchAppMenu);

