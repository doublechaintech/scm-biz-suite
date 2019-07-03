

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
import styles from './LevelTwoDepartment.dashboard.less'
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


const imageList =(levelTwoDepartment)=>{return [
	 ]}

const internalImageListOf = (levelTwoDepartment) =>defaultImageListOf(levelTwoDepartment,imageList)

const optionList =(levelTwoDepartment)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (levelTwoDepartment) =>defaultSettingListOf(levelTwoDepartment, optionList)
const internalLargeTextOf = (levelTwoDepartment) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (levelTwoDepartment,targetComponent) =>{
	
	
	const {LevelTwoDepartmentService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelTwoDepartment.id}</Description> 
<Description term="属于">{levelTwoDepartment.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${levelTwoDepartment.belongsTo.displayName}(${levelTwoDepartment.belongsTo.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"属于","levelOneDepartment",LevelTwoDepartmentService.requestCandidateBelongsTo,
	      LevelTwoDepartmentService.transferToAnotherBelongsTo,"anotherBelongsToId",levelTwoDepartment.belongsTo?levelTwoDepartment.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="名称">{levelTwoDepartment.name}</Description> 
<Description term="描述">{levelTwoDepartment.description}</Description> 
<Description term="成立">{ moment(levelTwoDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(levelTwoDepartment,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class LevelTwoDepartmentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'levelTwoDepartment'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, levelThreeDepartmentListMetaInfo, levelThreeDepartmentCount } = this.props.levelTwoDepartment
    if(!this.props.levelTwoDepartment.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"二级部门",cardsFor: "levelTwoDepartment",
    	cardsSource: this.props.levelTwoDepartment,returnURL,displayName,
  		subItems: [
{name: 'levelThreeDepartmentList', displayName:'三级部门',type:'levelThreeDepartment',count:levelThreeDepartmentCount,addFunction: true, role: 'levelThreeDepartment', metaInfo: levelThreeDepartmentListMetaInfo, renderItem: GlobalComponents.LevelThreeDepartmentBase.renderItemOfList},
    
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
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  levelTwoDepartment: state._levelTwoDepartment,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(LevelTwoDepartmentDashboard))

