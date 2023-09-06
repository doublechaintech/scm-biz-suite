

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UiAction.dashboard.less'
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

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(uiAction)=>{return [
	   {"title":'图片链接',"imageLocation":uiAction.imageUrl},
]}

const internalImageListOf = (uiAction) =>defaultImageListOf(uiAction,imageList)

const optionList =(uiAction)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (uiAction) =>defaultSettingListOf(uiAction, optionList)
const internalLargeTextOf = (uiAction) =>{

	return(<div> 
   <Card title={`额外的数据`} ><pre>{uiAction.extraData}</pre></Card>
</div>)



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
      <Link to={`/uiAction/${targetComponent.props.uiAction.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/uiAction/${targetComponent.props.uiAction.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{


  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const uiAction = cardsData.cardsSource
	const {UiActionService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{uiAction.id}</Description> 
<Description term="代码" style={{wordBreak: 'break-all'}}>{uiAction.code}</Description> 
<Description term="图标" style={{wordBreak: 'break-all'}}>{uiAction.icon}</Description> 
<Description term="头衔" style={{wordBreak: 'break-all'}}>{uiAction.title}</Description> 
<Description term="顺序" style={{wordBreak: 'break-all'}}>{uiAction.displayOrder}</Description> 
<Description term="短暂的" style={{wordBreak: 'break-all'}}>{uiAction.brief}</Description> 

<Description term="链接网址" style={{wordBreak: 'break-all'}}>{uiAction.linkToUrl}</Description> 
<Description term="页面">{uiAction.page==null?appLocaleName(userContext,"NotAssigned"):`${uiAction.page.displayName}(${uiAction.page.id})`}
</Description>

       
      </DescriptionList>
      <div>{quickFunctions(cardsData)}</div>
      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


}


const internalQuickFunctions = defaultQuickFunctions

class UiActionDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",
    defaultType: 'uiAction'


  }
  componentDidMount() {

  }


  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.uiAction
    if(!this.props.uiAction.class){
      return null
    }
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('ui_action'),cardsFor: "uiAction",
    	cardsSource: this.props.uiAction,returnURL,displayName,
  		subItems: [

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
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >


       
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  uiAction: state._uiAction,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(UiActionDashboard))

