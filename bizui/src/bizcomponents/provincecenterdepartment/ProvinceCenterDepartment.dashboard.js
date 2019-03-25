

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ProvinceCenterDepartment.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(provinceCenterDepartment)=>{return [
	 ]}

const internalImageListOf = (provinceCenterDepartment) =>defaultImageListOf(provinceCenterDepartment,imageList)

const optionList =(provinceCenterDepartment)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (provinceCenterDepartment) =>defaultSettingListOf(provinceCenterDepartment, optionList)
const internalLargeTextOf = (provinceCenterDepartment) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (provinceCenterDepartment,targetComponent) =>{
	
	
	const {ProvinceCenterDepartmentService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{provinceCenterDepartment.id}</Description> 
<Description term="名称">{provinceCenterDepartment.name}</Description> 
<Description term="成立">{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</Description> 
<Description term="省中心">{provinceCenterDepartment.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterDepartment.provinceCenter.displayName}(${provinceCenterDepartment.provinceCenter.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"省中心","retailStoreProvinceCenter",ProvinceCenterDepartmentService.requestCandidateProvinceCenter,
	      ProvinceCenterDepartmentService.transferToAnotherProvinceCenter,"anotherProvinceCenterId",provinceCenterDepartment.provinceCenter?provinceCenterDepartment.provinceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="经理">{provinceCenterDepartment.manager}</Description> 
	
        {buildTransferModal(provinceCenterDepartment,targetComponent)}
      </DescriptionList>
	)

}


class ProvinceCenterDepartmentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'provinceCenterDepartment'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, provinceCenterEmployeeListMetaInfo, provinceCenterEmployeeCount } = this.props.provinceCenterDepartment
    if(!this.props.provinceCenterDepartment.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"省中心",cardsFor: "provinceCenterDepartment",
    	cardsSource: this.props.provinceCenterDepartment,returnURL,displayName,
  		subItems: [
{name: 'provinceCenterEmployeeList', displayName:'省中心员工',type:'provinceCenterEmployee',count:provinceCenterEmployeeCount,addFunction: true, role: 'provinceCenterEmployee', metaInfo: provinceCenterEmployeeListMetaInfo},
    
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
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  provinceCenterDepartment: state._provinceCenterDepartment,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ProvinceCenterDepartmentDashboard))

