

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
import styles from './PotentialCustomerContact.dashboard.less'
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


const imageList =(potentialCustomerContact)=>{return [
	 ]}

const internalImageListOf = (potentialCustomerContact) =>defaultImageListOf(potentialCustomerContact,imageList)

const optionList =(potentialCustomerContact)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (potentialCustomerContact) =>defaultSettingListOf(potentialCustomerContact, optionList)
const internalLargeTextOf = (potentialCustomerContact) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (potentialCustomerContact,targetComponent) =>{
	
	
	const {PotentialCustomerContactService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{potentialCustomerContact.id}</Description> 
<Description term="名称">{potentialCustomerContact.name}</Description> 
<Description term="接触日期">{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</Description> 
<Description term="接触法">{potentialCustomerContact.contactMethod}</Description> 
<Description term="潜在的客户">{potentialCustomerContact.potentialCustomer==null?"未分配":potentialCustomerContact.potentialCustomer.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"潜在的客户","potentialCustomer",PotentialCustomerContactService.requestCandidatePotentialCustomer,
	      PotentialCustomerContactService.transferToAnotherPotentialCustomer,"anotherPotentialCustomerId",potentialCustomerContact.potentialCustomer?potentialCustomerContact.potentialCustomer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="城市合伙人">{potentialCustomerContact.cityPartner==null?"未分配":potentialCustomerContact.cityPartner.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市合伙人","cityPartner",PotentialCustomerContactService.requestCandidateCityPartner,
	      PotentialCustomerContactService.transferToAnotherCityPartner,"anotherCityPartnerId",potentialCustomerContact.cityPartner?potentialCustomerContact.cityPartner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="接触">{potentialCustomerContact.contactTo==null?"未分配":potentialCustomerContact.contactTo.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"接触","potentialCustomerContactPerson",PotentialCustomerContactService.requestCandidateContactTo,
	      PotentialCustomerContactService.transferToAnotherContactTo,"anotherContactToId",potentialCustomerContact.contactTo?potentialCustomerContact.contactTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="描述">{potentialCustomerContact.description}</Description> 
	
        {buildTransferModal(potentialCustomerContact,targetComponent)}
      </DescriptionList>
	)

}


class PotentialCustomerContactDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomerContact'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.potentialCustomerContact
    if(!this.props.potentialCustomerContact.class){
      return null
    }
    const cardsData = {cardsName:"潜在客户联系",cardsFor: "potentialCustomerContact",cardsSource: this.props.potentialCustomerContact,
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
  potentialCustomerContact: state._potentialCustomerContact,
}))(Form.create()(PotentialCustomerContactDashboard))

