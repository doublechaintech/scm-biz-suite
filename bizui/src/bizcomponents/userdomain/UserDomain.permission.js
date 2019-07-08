

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
import styles from './UserDomain.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (userDomain,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{userDomain.id}</Description> 
<Description term="Name">{userDomain.name}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = userDomain => {
  const {UserDomainBase} = GlobalComponents
  return <PermissionSetting targetObject={userDomain}  targetObjectMeta={UserDomainBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class UserDomainPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  userDomain = this.props.userDomain;
    const { id,displayName, userWhiteListCount, secUserCount } = userDomain
    const cardsData = {cardsName:"User Domain",cardsFor: "userDomain",cardsSource: userDomain,
  		subItems: [
{name: 'userWhiteListList', displayName:'User White List',type:'userWhiteList',count:userWhiteListCount,addFunction: true, role: 'userWhiteList', data: userDomain.userWhiteListList},
    
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
  userDomain: state._userDomain,
}))(Form.create()(UserDomainPermission))

