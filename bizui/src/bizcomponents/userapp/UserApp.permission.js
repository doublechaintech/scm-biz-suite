

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UserApp.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (userApp,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{userApp.id}</Description> 
<Description term="Title">{userApp.title}</Description> 
<Description term="App Icon">{userApp.appIcon}</Description> 
<Description term="Permission">{userApp.permission}</Description> 
<Description term="Object Type">{userApp.objectType}</Description> 
<Description term="Object Id">{userApp.objectId}</Description> 
<Description term="Location">{userApp.location}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = userApp => {
  const {UserAppBase} = GlobalComponents
  return <PermissionSetting targetObject={userApp}  targetObjectMeta={UserAppBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class UserAppPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  userApp = this.props.userApp;
    const { id,displayName, listAccessCount, objectAccessCount } = userApp
    const cardsData = {cardsName:"User App",cardsFor: "userApp",cardsSource: userApp,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  userApp: state._userApp,
}))(Form.create()(UserAppPermission))

