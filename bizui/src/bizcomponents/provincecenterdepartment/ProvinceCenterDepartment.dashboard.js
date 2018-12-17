

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

const internalSummaryOf = (provinceCenterDepartment,targetComponent) =>{
	
	
	const {ProvinceCenterDepartmentService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{provinceCenterDepartment.id}</Description> 
<Description term="名称">{provinceCenterDepartment.name}</Description> 
<Description term="成立">{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</Description> 
<Description term="省中心">{provinceCenterDepartment.provinceCenter==null?"未分配":provinceCenterDepartment.provinceCenter.displayName}
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
    targetLocalName:"城市",
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
    const cardsData = {cardsName:"省中心",cardsFor: "provinceCenterDepartment",cardsSource: this.props.provinceCenterDepartment,
  		subItems: [
{name: 'provinceCenterEmployeeList', displayName:'省中心员工',type:'provinceCenterEmployee',count:provinceCenterEmployeeCount,addFunction: true, role: 'provinceCenterEmployee', metaInfo: provinceCenterEmployeeListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
}))(Form.create()(ProvinceCenterDepartmentDashboard))

