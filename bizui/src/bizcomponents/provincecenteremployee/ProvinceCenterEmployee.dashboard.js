

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
import styles from './ProvinceCenterEmployee.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'


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


const imageList =(provinceCenterEmployee)=>{return [
	 ]}

const internalImageListOf = (provinceCenterEmployee) =>defaultImageListOf(provinceCenterEmployee,imageList)

const optionList =(provinceCenterEmployee)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (provinceCenterEmployee) =>defaultSettingListOf(provinceCenterEmployee, optionList)
const internalLargeTextOf = (provinceCenterEmployee) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (provinceCenterEmployee,targetComponent) =>{
	
	
	const {ProvinceCenterEmployeeService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{provinceCenterEmployee.id}</Description> 
<Description term="名称">{provinceCenterEmployee.name}</Description> 
<Description term="手机">{provinceCenterEmployee.mobile}</Description> 
<Description term="电子邮件">{provinceCenterEmployee.email}</Description> 
<Description term="成立">{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</Description> 
<Description term="部门">{provinceCenterEmployee.department==null?"未分配":provinceCenterEmployee.department.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"部门","provinceCenterDepartment",ProvinceCenterEmployeeService.requestCandidateDepartment,
	      ProvinceCenterEmployeeService.transferToAnotherDepartment,"anotherDepartmentId",provinceCenterEmployee.department?provinceCenterEmployee.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="省中心">{provinceCenterEmployee.provinceCenter==null?"未分配":provinceCenterEmployee.provinceCenter.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"省中心","retailStoreProvinceCenter",ProvinceCenterEmployeeService.requestCandidateProvinceCenter,
	      ProvinceCenterEmployeeService.transferToAnotherProvinceCenter,"anotherProvinceCenterId",provinceCenterEmployee.provinceCenter?provinceCenterEmployee.provinceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(provinceCenterEmployee,targetComponent)}
      </DescriptionList>
	)

}


class ProvinceCenterEmployeeDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'provinceCenterEmployee'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.provinceCenterEmployee
    if(!this.props.provinceCenterEmployee.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"省中心员工",cardsFor: "provinceCenterEmployee",
    	cardsSource: this.props.provinceCenterEmployee,returnURL,displayName,
  		subItems: [
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
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
  provinceCenterEmployee: state._provinceCenterEmployee,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ProvinceCenterEmployeeDashboard))

