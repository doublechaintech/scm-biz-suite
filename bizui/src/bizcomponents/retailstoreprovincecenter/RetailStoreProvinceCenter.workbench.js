

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
import styles from './RetailStoreProvinceCenter.workbench.less'
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


const imageList =(retailStoreProvinceCenter)=>{return [
	 ]}

const internalImageListOf = (retailStoreProvinceCenter) =>defaultImageListOf(retailStoreProvinceCenter,imageList)

const optionList =(retailStoreProvinceCenter)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStoreProvinceCenter) =>defaultSettingListOf(retailStoreProvinceCenter, optionList)
const internalLargeTextOf = (retailStoreProvinceCenter) =>{

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
      <Link to={`/retailStoreProvinceCenter/${targetComponent.props.retailStoreProvinceCenter.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStoreProvinceCenter/${targetComponent.props.retailStoreProvinceCenter.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
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
	const retailStoreProvinceCenter = cardsData.cardsSource
	const {RetailStoreProvinceCenterService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.name}</Description> 
<Description term="成立">{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="更新于">{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 

      
      </DescriptionList>

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

class RetailStoreProvinceCenterWorkbench extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",
    defaultType: 'retailStoreProvinceCenter'


  }
  componentDidMount() {

  }


  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, provinceCenterDepartmentListMetaInfo, provinceCenterEmployeeListMetaInfo, retailStoreCityServiceCenterListMetaInfo, provinceCenterDepartmentCount, provinceCenterEmployeeCount, retailStoreCityServiceCenterCount } = this.props.retailStoreProvinceCenter
    if(!this.props.retailStoreProvinceCenter.class){
      return null
    }
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('retail_store_province_center'),cardsFor: "retailStoreProvinceCenter",
    	cardsSource: this.props.retailStoreProvinceCenter,returnURL,displayName,
  		subItems: [
{name: 'provinceCenterEmployeeList', displayName: window.mtrans('province_center_employee','retail_store_province_center.province_center_employee_list',false) ,viewGroup:'__no_group', type:'provinceCenterEmployee',count:provinceCenterEmployeeCount,addFunction: true, role: 'provinceCenterEmployee', metaInfo: provinceCenterEmployeeListMetaInfo, renderItem: GlobalComponents.ProvinceCenterEmployeeBase.renderItemOfList},
{name: 'retailStoreCityServiceCenterList', displayName: window.mtrans('retail_store_city_service_center','retail_store_province_center.retail_store_city_service_center_list',false) ,viewGroup:'__no_group', type:'retailStoreCityServiceCenter',count:retailStoreCityServiceCenterCount,addFunction: true, role: 'retailStoreCityServiceCenter', metaInfo: retailStoreCityServiceCenterListMetaInfo, renderItem: GlobalComponents.RetailStoreCityServiceCenterBase.renderItemOfList},

      	],
   		subSettingItems: [
{name: 'provinceCenterDepartmentList', displayName: window.mtrans('province_center_department','retail_store_province_center.province_center_department_list',false),type:'provinceCenterDepartment',count:provinceCenterDepartmentCount,addFunction: true, role: 'provinceCenterDepartment', metaInfo: provinceCenterDepartmentListMetaInfo, renderItem: GlobalComponents.ProvinceCenterDepartmentBase.renderItemOfList},

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
        content={summaryOf(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >

      
       
     <Col span={18} style={{marginRight:"20px", backgroundColor: "white"}}>
      {quickFunctions(cardsData)}

      {largeTextOf(cardsData.cardsSource)}
      {renderSubjectList(cardsData)} 
      {renderExtraFooter(cardsData.cardsSource)}
	   </Col>
      <Col span={5}>

			{imageListOf(cardsData.cardsSource)}
			{settingListOf(cardsData.cardsSource)}
		</Col>
		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(RetailStoreProvinceCenterWorkbench))

