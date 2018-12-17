

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
import styles from './ReportLine.dashboard.less'
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


const imageList =(reportLine)=>{return [
	 ]}

const internalImageListOf = (reportLine) =>defaultImageListOf(reportLine,imageList)

const optionList =(reportLine)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (reportLine) =>defaultSettingListOf(reportLine, optionList)
const internalLargeTextOf = (reportLine) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (reportLine,targetComponent) =>{
	
	
	const {ReportLineService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{reportLine.id}</Description> 
<Description term="名称">{reportLine.name}</Description> 
<Description term="业主">{reportLine.owner==null?"未分配":reportLine.owner.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"业主","report",ReportLineService.requestCandidateOwner,
	      ReportLineService.transferToAnotherOwner,"anotherOwnerId",reportLine.owner?reportLine.owner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="一月">{reportLine.january}</Description> 
<Description term="二月">{reportLine.february}</Description> 
<Description term="三月">{reportLine.march}</Description> 
<Description term="四月">{reportLine.april}</Description> 
<Description term="五月">{reportLine.may}</Description> 
<Description term="六月">{reportLine.june}</Description> 
<Description term="七月">{reportLine.july}</Description> 
<Description term="八月">{reportLine.august}</Description> 
<Description term="九月">{reportLine.september}</Description> 
<Description term="十月">{reportLine.october}</Description> 
<Description term="十一月">{reportLine.november}</Description> 
<Description term="十二月">{reportLine.december}</Description> 
	
        {buildTransferModal(reportLine,targetComponent)}
      </DescriptionList>
	)

}


class ReportLineDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'reportLine'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.reportLine
    if(!this.props.reportLine.class){
      return null
    }
    const cardsData = {cardsName:"报告线",cardsFor: "reportLine",cardsSource: this.props.reportLine,
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
  reportLine: state._reportLine,
}))(Form.create()(ReportLineDashboard))

