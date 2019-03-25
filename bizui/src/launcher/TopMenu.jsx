import { Menu, Icon } from 'antd';
import React from 'react';

import { Link } from 'react-router';
import ChangePasswordModel from './ChangePassword.modal';
import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

const ChangePassword = 'ChangePassword';

class TopMenu extends React.Component {
  state = {
    currentKey: 'app5',
    ChangePasswordVisible: false,
  };
  handleClick = e => {
    console.log('click ', e);

    if (e.key && e.key == ChangePassword) {
      console.log('trying to change password');
      this.setState({
        currentKey: ChangePassword,
        ChangePasswordVisible: !this.state.ChangePasswordVisible,
      });

      return;
    }

    console.log('props', this.props);
    const dispatch = this.props.dispatch;
    dispatch({ type: 'launcher/signOut' });
    this.setState({
      currentKey: e.key,
    });
  };

  linkto = value => {
    console.log('current selected', value);
    console.log('linkto props', this.props);
    const dispatch = this.props.dispatch;
    dispatch({ type: 'launcher/logout' });
  };

  hideModal = event => {
    console.log('hide modal called', event);

    this.setState({ ChangePasswordVisible: false });
  };

  render() {
    const userContext = this.props.launcher.data;

    return (
      <div>
        <Menu
          onClick={this.handleClick}
          selectedKeys={[this.state.current]}
          mode="horizontal"
          theme="dark"
        >
          <Menu.Item key="logout" style={{ float: 'right' }}>
            <Icon type="logout" />
            {launcherLocaleName(userContext, 'Exit')}
          </Menu.Item>
          <Menu.Item key={ChangePassword} style={{ float: 'right' }}>
            <Icon type="lock" />
            {launcherLocaleName(userContext, 'ChangePassword')}
          </Menu.Item>
        </Menu>{' '}
        <ChangePasswordModel
          visible={this.state.ChangePasswordVisible}
          hideModal={event => this.hideModal(event)}
        />
      </div>
    );
  }
}

export default TopMenu;
