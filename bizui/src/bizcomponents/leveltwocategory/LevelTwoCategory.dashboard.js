

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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
import styles from './LevelTwoCategory.dashboard.less'
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


const imageList =(levelTwoCategory)=>{return [
	 ]}

const internalImageListOf = (levelTwoCategory) =>defaultImageListOf(levelTwoCategory,imageList)

const optionList =(levelTwoCategory)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (levelTwoCategory) =>defaultSettingListOf(levelTwoCategory, optionList)
const internalLargeTextOf = (levelTwoCategory) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight">
        <Icon
          type="setting"
        />
      </Dropdown>)


}

const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/levelTwoCategory/${targetComponent.props.levelTwoCategory.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Item key="permission">
  			<Link to={`/levelTwoCategory/${targetComponent.props.levelTwoCategory.id}/profile`}><Icon type="cluster"  twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Profile")}</span></Link>
			</Menu.Item>
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (levelTwoCategory,targetComponent) =>{
	
	
	const {LevelTwoCategoryService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelTwoCategory.id}</Description> 
<Description term="父类">{levelTwoCategory.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${levelTwoCategory.parentCategory.displayName}(${levelTwoCategory.parentCategory.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"父类","levelOneCategory",LevelTwoCategoryService.requestCandidateParentCategory,
	      LevelTwoCategoryService.transferToAnotherParentCategory,"anotherParentCategoryId",levelTwoCategory.parentCategory?levelTwoCategory.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="名称">{levelTwoCategory.name}</Description> 
	
        {buildTransferModal(levelTwoCategory,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class LevelTwoCategoryDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'levelTwoCategory'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, levelThreeCategoryListMetaInfo, levelThreeCategoryCount } = this.props.levelTwoCategory
    if(!this.props.levelTwoCategory.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"二级分类",cardsFor: "levelTwoCategory",
    	cardsSource: this.props.levelTwoCategory,returnURL,displayName,
  		subItems: [
{name: 'levelThreeCategoryList', displayName:'三级分类',type:'levelThreeCategory',count:levelThreeCategoryCount,addFunction: true, role: 'levelThreeCategory', metaInfo: levelThreeCategoryListMetaInfo, renderItem: GlobalComponents.LevelThreeCategoryBase.renderItemOfList},
    
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
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
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
  levelTwoCategory: state._levelTwoCategory,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(LevelTwoCategoryDashboard))

