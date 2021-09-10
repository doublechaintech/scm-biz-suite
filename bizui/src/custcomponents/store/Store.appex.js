import StoreBizApp from '../../bizcomponents/store/Store.app'

import React from 'react'
import { connect } from 'dva'

import styles from './Store.appex.less'


import About from '../about/About'

class StoreBizAppEx extends React.PureComponent {
  
  extraRoutesFunc=()=>{

    return [{path:'/store/:id/about', component:About}];

  }
  render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     //console.log("this.extraRoutesFunc------------",this.extraRoutesFunc());
     return (
      <StoreBizApp extraRoutesFunc={this.extraRoutesFunc} {...this.props}/>
     )
   }
}


export default connect(state => ({  
  
  customized:'yes',
}))(StoreBizAppEx)


/*

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  store: state._store,
  extra:'yes',
  ...state,
}))(StoreBizAppEx)


import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,
} from 'antd'
import DocumentTitle from 'react-document-title'

import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Store.appex.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


*/

