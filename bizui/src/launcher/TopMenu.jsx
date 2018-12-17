import { Menu, Icon } from 'antd';
import React from 'react';

import { Link } from 'react-router';
import ChangePasswordModel from './ChangePassword.modal'

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

const CHANGEPASSWORD="changepassword"

class TopMenu extends React.Component {
  state = {
    currentKey: 'app5',
    changePasswordVisible: false
  }
  handleClick = (e) => {
    console.log('click ', e);
  

    if(e.key&&e.key==CHANGEPASSWORD){
      console.log("trying to change password")
      this.setState({currentKey:CHANGEPASSWORD,changePasswordVisible:!this.state.changePasswordVisible})
      
      return
    }
    

    console.log("props", this.props);
    const dispatch=this.props.dispatch;
    dispatch({type:"launcher/signOut"});
    this.setState({
      currentKey: e.key,
    });
    

  }

  linkto = (value) => {
    
    console.log("current selected", value)
    console.log("linkto props", this.props);
    const dispatch=this.props.dispatch;
    dispatch({type:"launcher/logout"});
  }
  
  hideModal=(event)=>{
    console.log("hide modal called", event)
   
    this.setState({changePasswordVisible:false})
    
    
  }


  render() {



    return (
      <div>
      <Menu
        onClick={this.handleClick}
        selectedKeys={[this.state.current]}
        mode="horizontal"
        theme="dark"
      >
      
        <Menu.Item key="logout" style={{float:"right"}}>
        <Icon type="logout" />退出
        </Menu.Item>
        <Menu.Item key={CHANGEPASSWORD} style={{float:"right"}}>
        <Icon type="lock" />更改密码

       
        </Menu.Item>
      




      </Menu> <ChangePasswordModel visible={this.state.changePasswordVisible} hideModal={(event)=>this.hideModal(event)}/></div>

    );
  }
}

export default TopMenu;