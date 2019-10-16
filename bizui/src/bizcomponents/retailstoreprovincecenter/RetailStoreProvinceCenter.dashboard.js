

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
import styles from './RetailStoreProvinceCenter.dashboard.less'
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


const imageList =(retailStoreProvinceCenter)=>{return [
	 ]}

const internalImageListOf = (retailStoreProvinceCenter) =>defaultImageListOf(retailStoreProvinceCenter,imageList)

const optionList =(retailStoreProvinceCenter)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (retailStoreProvinceCenter) =>defaultSettingListOf(retailStoreProvinceCenter, optionList)
const internalLargeTextOf = (retailStoreProvinceCenter) =>{

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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (retailStoreProvinceCenter,targetComponent) =>{
	
	
	const {RetailStoreProvinceCenterService} = GlobalComponents
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreProvinceCenter.id}</Description> 
<Description term="名称">{retailStoreProvinceCenter.name}</Description> 
<Description term="成立">{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</Description> 
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	
        {buildTransferModal(retailStoreProvinceCenter,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class RetailStoreProvinceCenterDashboard extends Component {

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
    
    const cardsData = {cardsName:"双链小超省中心",cardsFor: "retailStoreProvinceCenter",
    	cardsSource: this.props.retailStoreProvinceCenter,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'provinceCenterEmployeeList', displayName:'省中心员工',type:'provinceCenterEmployee',count:provinceCenterEmployeeCount,addFunction: true, role: 'provinceCenterEmployee', metaInfo: provinceCenterEmployeeListMetaInfo},
{name: 'retailStoreCityServiceCenterList', displayName:'双链小超城市服务中心',type:'retailStoreCityServiceCenter',count:retailStoreCityServiceCenterCount,addFunction: true, role: 'retailStoreCityServiceCenter', metaInfo: retailStoreCityServiceCenterListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'provinceCenterEmployeeList', displayName:'省中心员工',type:'provinceCenterEmployee',count:provinceCenterEmployeeCount,addFunction: true, role: 'provinceCenterEmployee', metaInfo: provinceCenterEmployeeListMetaInfo, renderItem: GlobalComponents.ProvinceCenterEmployeeBase.renderItemOfList},
{name: 'retailStoreCityServiceCenterList', displayName:'双链小超城市服务中心',type:'retailStoreCityServiceCenter',count:retailStoreCityServiceCenterCount,addFunction: true, role: 'retailStoreCityServiceCenter', metaInfo: retailStoreCityServiceCenterListMetaInfo, renderItem: GlobalComponents.RetailStoreCityServiceCenterBase.renderItemOfList},
    
      	],
   		subSettingItems: [
{name: 'provinceCenterDepartmentList', displayName:'省中心',type:'provinceCenterDepartment',count:provinceCenterDepartmentCount,addFunction: true, role: 'provinceCenterDepartment', metaInfo: provinceCenterDepartmentListMetaInfo, renderItem: GlobalComponents.ProvinceCenterDepartmentBase.renderItemOfList},
    
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
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreProvinceCenterDashboard))

