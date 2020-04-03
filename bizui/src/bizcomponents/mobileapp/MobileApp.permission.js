

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './MobileApp.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (mobileApp,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{mobileApp.id}</Description> 
<Description term="名称">{mobileApp.name}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = mobileApp => {
  const {MobileAppBase} = GlobalComponents
  return <PermissionSetting targetObject={mobileApp}  targetObjectMeta={MobileAppBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class MobileAppPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  mobileApp = this.props.mobileApp
    const { id,displayName, pageCount, pageTypeCount } = mobileApp
    const  returnURL = `/mobileApp/${id}/dashboard`
    const cardsData = {cardsName:"手机应用程序",cardsFor: "mobileApp",cardsSource: mobileApp,displayName,returnURL,
  		subItems: [
{name: 'pageTypeList', displayName:'页面类型',type:'pageType',count:pageTypeCount,addFunction: false, role: 'pageType', data: mobileApp.pageTypeList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  mobileApp: state._mobileApp,
}))(Form.create()(MobileAppPermission))

