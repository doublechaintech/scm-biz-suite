

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UserApp.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(userApp)=>{return [
	 ]}

const internalImageListOf = (userApp) =>defaultImageListOf(userApp,imageList)

const optionList =(userApp)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (userApp) =>defaultSettingListOf(userApp, optionList)
const internalLargeTextOf = (userApp) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<div style={{float: 'right'}} >
        <Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight" >
       
        <Button>
        <Icon type="setting" theme="filled" twoToneColor="#00b" style={{color:'#3333b0'}}/> 设置  <Icon type="down"/>
      </Button>
      </Dropdown></div>)

}

const renderSettingMenuItem = (item,cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu.Item key={item.name}>
      <Link to={`/userApp/${targetComponent.props.userApp.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/userApp/${targetComponent.props.userApp.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (userApp,targetComponent) =>{
	
	
	const {UserAppService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{userApp.id}</Description> 
<Description term="头衔" style={{wordBreak: 'break-all'}}>{userApp.title}</Description> 
<Description term="SEC的用户">{userApp.secUser==null?appLocaleName(userContext,"NotAssigned"):`${userApp.secUser.displayName}(${userApp.secUser.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"SEC的用户","secUser",UserAppService.requestCandidateSecUser,
	      UserAppService.transferToAnotherSecUser,"anotherSecUserId",userApp.secUser?userApp.secUser.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="应用程序图标" style={{wordBreak: 'break-all'}}>{userApp.appIcon}</Description> 
<Description term="完全访问" style={{wordBreak: 'break-all'}}>{userApp.fullAccess}</Description> 
<Description term="许可" style={{wordBreak: 'break-all'}}>{userApp.permission}</Description> 
<Description term="对象类型" style={{wordBreak: 'break-all'}}>{userApp.objectType}</Description> 
<Description term="对象ID" style={{wordBreak: 'break-all'}}>{userApp.objectId}</Description> 
<Description term="位置" style={{wordBreak: 'break-all'}}>{userApp.location}</Description> 
	
        {buildTransferModal(userApp,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class UserAppDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'userApp'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, quickLinkListMetaInfo, listAccessListMetaInfo, quickLinkCount, listAccessCount } = this.props.userApp
    if(!this.props.userApp.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:window.trans('user_app'),cardsFor: "userApp",
    	cardsSource: this.props.userApp,returnURL,displayName,
  		subItems: [
{name: 'quickLinkList', displayName: window.mtrans('quick_link','user_app.quick_link_list',false) ,viewGroup:'__no_group', type:'quickLink',count:quickLinkCount,addFunction: true, role: 'quickLink', metaInfo: quickLinkListMetaInfo, renderItem: GlobalComponents.QuickLinkBase.renderItemOfList},
{name: 'listAccessList', displayName: window.mtrans('list_access','user_app.list_access_list',false) ,viewGroup:'__no_group', type:'listAccess',count:listAccessCount,addFunction: true, role: 'listAccess', metaInfo: listAccessListMetaInfo, renderItem: GlobalComponents.ListAccessBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
        
        {quickFunctions(cardsData)} 
        {imageListOf(cardsData.cardsSource)}  
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  userApp: state._userApp,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(UserAppDashboard))

