

import React, { Component } from 'react'
<<<<<<< HEAD
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
=======
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
<<<<<<< HEAD
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
=======
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(userApp)=>{return [
	 ]}

const internalImageListOf = (userApp) =>defaultImageListOf(userApp,imageList)

const optionList =(userApp)=>{return [ 
	  {"title":'完全访问',"value":userApp.fullAccess,"parameterName":"fullAccess"},
]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (userApp) =>defaultSettingListOf(userApp, optionList)
const internalLargeTextOf = (userApp) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


<<<<<<< HEAD
const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)
=======
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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (userApp,targetComponent) =>{
	
	
	const {UserAppService} = GlobalComponents
<<<<<<< HEAD
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{userApp.id}</Description> 
<Description term="头衔">{userApp.title}</Description> 
<Description term="SEC的用户">{userApp.secUser==null?"未分配":userApp.secUser.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"SEC的用户","secUser",UserAppService.requestCandidateSecUser,
=======
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{userApp.id}</Description> 
<Description term="标题">{userApp.title}</Description> 
<Description term="安全用户">{userApp.secUser==null?appLocaleName(userContext,"NotAssigned"):`${userApp.secUser.displayName}(${userApp.secUser.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"安全用户","secUser",UserAppService.requestCandidateSecUser,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	      UserAppService.transferToAnotherSecUser,"anotherSecUserId",userApp.secUser?userApp.secUser.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="应用程序图标">{userApp.appIcon}</Description> 
<Description term="许可">{userApp.permission}</Description> 
<<<<<<< HEAD
<Description term="对象类型">{userApp.objectType}</Description> 
=======
<Description term="访问对象类型">{userApp.objectType}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
<Description term="对象ID">{userApp.objectId}</Description> 
<Description term="位置">{userApp.location}</Description> 
	
        {buildTransferModal(userApp,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class UserAppDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
<<<<<<< HEAD
    targetLocalName:"城市",
=======
    targetLocalName:"",
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'userApp'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
<<<<<<< HEAD
    const { id,displayName, listAccessListMetaInfo, objectAccessListMetaInfo, listAccessCount, objectAccessCount } = this.props.userApp
=======
    const { id,displayName, quickLinkListMetaInfo, listAccessListMetaInfo, objectAccessListMetaInfo, quickLinkCount, listAccessCount, objectAccessCount } = this.props.userApp
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    if(!this.props.userApp.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"用户应用程序",cardsFor: "userApp",
    	cardsSource: this.props.userApp,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'listAccessList', displayName:'访问列表',type:'listAccess',count:listAccessCount,addFunction: true, role: 'listAccess', metaInfo: listAccessListMetaInfo},
{name: 'objectAccessList', displayName:'对象访问',type:'objectAccess',count:objectAccessCount,addFunction: true, role: 'objectAccess', metaInfo: objectAccessListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'quickLinkList', displayName:'快速链接',type:'quickLink',count:quickLinkCount,addFunction: true, role: 'quickLink', metaInfo: quickLinkListMetaInfo, renderItem: GlobalComponents.QuickLinkBase.renderItemOfList},
{name: 'listAccessList', displayName:'访问列表',type:'listAccess',count:listAccessCount,addFunction: true, role: 'listAccess', metaInfo: listAccessListMetaInfo, renderItem: GlobalComponents.ListAccessBase.renderItemOfList},
{name: 'objectAccessList', displayName:'对象访问',type:'objectAccess',count:objectAccessCount,addFunction: true, role: 'objectAccess', metaInfo: objectAccessListMetaInfo, renderItem: GlobalComponents.ObjectAccessBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
<<<<<<< HEAD
=======
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
<<<<<<< HEAD
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
=======
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    )
  }
}

export default connect(state => ({
  userApp: state._userApp,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(UserAppDashboard))

