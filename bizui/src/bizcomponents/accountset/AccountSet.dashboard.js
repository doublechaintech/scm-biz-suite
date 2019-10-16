

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
import styles from './AccountSet.dashboard.less'
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


const imageList =(accountSet)=>{return [
	 ]}

const internalImageListOf = (accountSet) =>defaultImageListOf(accountSet,imageList)

const optionList =(accountSet)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (accountSet) =>defaultSettingListOf(accountSet, optionList)
const internalLargeTextOf = (accountSet) =>{

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
      <Link to={`/accountSet/${targetComponent.props.accountSet.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/accountSet/${targetComponent.props.accountSet.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
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


const internalSummaryOf = (accountSet,targetComponent) =>{
	
	
	const {AccountSetService} = GlobalComponents
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountSet.id}</Description> 
<Description term="名称">{accountSet.name}</Description> 
<Description term="年组">{accountSet.yearSet}</Description> 
<Description term="生效日期">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计制度">{accountSet.accountingSystem}</Description> 
<Description term="本币代码">{accountSet.domesticCurrencyCode}</Description> 
<Description term="本币名称">{accountSet.domesticCurrencyName}</Description> 
<Description term="开户银行">{accountSet.openingBank}</Description> 
<Description term="帐户号码">{accountSet.accountNumber}</Description> 
<<<<<<< HEAD
<Description term="双链小超">{accountSet.retailStore==null?"未分配":accountSet.retailStore.displayName}
=======
<Description term="双链小超">{accountSet.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.retailStore.displayName}(${accountSet.retailStore.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"双链小超","retailStore",AccountSetService.requestCandidateRetailStore,
	      AccountSetService.transferToAnotherRetailStore,"anotherRetailStoreId",accountSet.retailStore?accountSet.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="产品供应商">{accountSet.goodsSupplier==null?"未分配":accountSet.goodsSupplier.displayName}
=======
<Description term="产品供应商">{accountSet.goodsSupplier==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.goodsSupplier.displayName}(${accountSet.goodsSupplier.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"产品供应商","goodsSupplier",AccountSetService.requestCandidateGoodsSupplier,
	      AccountSetService.transferToAnotherGoodsSupplier,"anotherGoodsSupplierId",accountSet.goodsSupplier?accountSet.goodsSupplier.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	
        {buildTransferModal(accountSet,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class AccountSetDashboard extends Component {

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
    defaultType: 'accountSet'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, accountingSubjectListMetaInfo, accountingPeriodListMetaInfo, accountingDocumentTypeListMetaInfo, accountingSubjectCount, accountingPeriodCount, accountingDocumentTypeCount } = this.props.accountSet
    if(!this.props.accountSet.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"账套",cardsFor: "accountSet",
    	cardsSource: this.props.accountSet,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'accountingSubjectList', displayName:'会计科目',type:'accountingSubject',count:accountingSubjectCount,addFunction: true, role: 'accountingSubject', metaInfo: accountingSubjectListMetaInfo},
{name: 'accountingPeriodList', displayName:'会计期间',type:'accountingPeriod',count:accountingPeriodCount,addFunction: true, role: 'accountingPeriod', metaInfo: accountingPeriodListMetaInfo},
{name: 'accountingDocumentTypeList', displayName:'会计凭证类型',type:'accountingDocumentType',count:accountingDocumentTypeCount,addFunction: true, role: 'accountingDocumentType', metaInfo: accountingDocumentTypeListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'accountingSubjectList', displayName:'会计科目',type:'accountingSubject',count:accountingSubjectCount,addFunction: true, role: 'accountingSubject', metaInfo: accountingSubjectListMetaInfo, renderItem: GlobalComponents.AccountingSubjectBase.renderItemOfList},
{name: 'accountingPeriodList', displayName:'会计期间',type:'accountingPeriod',count:accountingPeriodCount,addFunction: true, role: 'accountingPeriod', metaInfo: accountingPeriodListMetaInfo, renderItem: GlobalComponents.AccountingPeriodBase.renderItemOfList},
{name: 'accountingDocumentTypeList', displayName:'会计凭证类型',type:'accountingDocumentType',count:accountingDocumentTypeCount,addFunction: true, role: 'accountingDocumentType', metaInfo: accountingDocumentTypeListMetaInfo, renderItem: GlobalComponents.AccountingDocumentTypeBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
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
  accountSet: state._accountSet,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountSetDashboard))

