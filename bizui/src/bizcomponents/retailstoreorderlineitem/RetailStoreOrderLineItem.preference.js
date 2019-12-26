

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
import styles from './RetailStoreOrderLineItem.preference.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select

const topColResponsiveProps = {
  xs: 8,
  sm: 6,
  md: 6,
  lg: 4,
  xl: 4,
  style: { marginBottom: 24 },
}


const internalImageListOf = (retailStoreOrderLineItem) =>{
  const userContext = null
  const imageList = [
	 ]
  const filteredList = imageList.filter((item)=>item.imageLocation!=null)
  if(filteredList.length===0){
    return null
  }

  return(<Card title={appLocaleName(userContext,"ImageList")} className={styles.card}><Row type="flex" justify="start" align="bottom">
  {
      filteredList.map((item,index)=>(<Col span={4} key={index}><ImagePreview imageTitle ={item.title} showTitleUnderImage={true} imageLocation={item.imageLocation} >{item.title}</ImagePreview></Col>))
  }</Row></Card> )

}

const internalSettingListOf = (retailStoreOrderLineItem) =>{
	const userContext = null
	const optionList = [ 
	]
	
  if(optionList.length===0){
    return null
  }
  return(<Card title={appLocaleName(userContext,"Switchers")} className={styles.card}>
  	
  	{
  	  optionList.map((item)=><Col key={item.parameterName} span={6} style={{"height":"60px"}}>
       <Switch  title={item.title} checked={item.value} type={item.value?"success":"error"} checkedChildren={appLocaleName(userContext,"Yes")} unCheckedChildren={appLocaleName(userContext,"No")} />
       <span style={{"margin":"10px"}}>{item.title}</span>
       </Col>)
  	}


</Card> )
	


}

const internalLargeTextOf = (retailStoreOrderLineItem) =>{

	return null
	

}

/////////////////////////////////////// BUILD FOR TRANSFERRING TO ANOTHER OBJECT////////////////////////////////////////////////

const handleTransferSearch =(targetComponent,filterKey,newRequest)=>{
  const {RetailStoreOrderLineItemService} = GlobalComponents;

  const parameters = newRequest||targetComponent.state

  const {
 
    candidateServiceName,
    candidateObjectType,
    targetLocalName,
 
  } = parameters

  console.log("current state", parameters)

  const id = "";//not used for now
  const pageNo = 1;
  const candidateReferenceService = RetailStoreOrderLineItemService[candidateServiceName] 
  if(!candidateReferenceService){
    console.log("current state", parameters)
    return;
  }
  //get a function for fetching the candidate reference list
  const future = candidateReferenceService(candidateObjectType, id, filterKey, pageNo);
  console.log(future);
  future.then(candidateReferenceList=>{
    targetComponent.setState({
     ...parameters,
      candidateReferenceList,
      transferModalVisiable:true,transferModalTitle:appLocaleName(userContext,"Reassign")+targetLocalName+">"
     
    })

  })

}
//  onClick={()=>showTransferModel(targetComponent,{appLocaleName(userContext,"City")},"city","requestCandidateDistrict","transferToAnotherDistrict")} 

const showTransferModel = (targetComponent,targetLocalName,
  candidateObjectType,candidateServiceName, transferServiceName, transferTargetParameterName,currentValue) => {

  const filterKey = ""

  const newRequest = {targetLocalName,candidateObjectType,candidateServiceName,transferServiceName,transferTargetParameterName,currentValue}
  console.log("showTransferModel  new state", newRequest)
  //targetComponent.setState(newState);
  handleTransferSearch(targetComponent,filterKey,newRequest)
}

const hideCloseTrans = (targetComponent) =>{
  targetComponent.setState({transferModalVisiable:false})

}

const executeTrans = (retailStoreOrderLineItem,targetComponent) =>{
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form
  const {
   
    candidateServiceName,
    candidateObjectType,
    targetLocalName,
    transferServiceName
  } = targetComponent.state

  const {dispatch} = targetComponent.props

  validateFieldsAndScroll((error, values) => {
    console.log("error", values)

    const parameters  = {...values}
    const id=retailStoreOrderLineItem.id;
    const serviceNameToCall = transferServiceName;

    const payload = {parameters,id,serviceNameToCall}
    
    //targetComponent.setState({transferModalVisiable:false})
    dispatch({type:"_retailStoreOrderLineItem/doJob",payload: payload})

    targetComponent.setState({transferModalVisiable:false})

  })
 

}


const buildTransferModal = (retailStoreOrderLineItem,targetComponent) => {


  const {transferModalVisiable,targetLocalName,transferModalTitle,
    candidateReferenceList,transferTargetParameterName,currentValue} = targetComponent.state
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form


  if(!candidateReferenceList||!candidateReferenceList.candidates){
    return null;
  }


  const formItemLayout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 16 },
  }

  return(

<Modal title={transferModalTitle}
          visible={transferModalVisiable}
          onOk={()=>executeTrans(retailStoreOrderLineItem,targetComponent)}
          onCancel={()=>hideCloseTrans(targetComponent)}
          
        >

  <Form >
            <Row gutter={16}>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={`${appLocaleName(userContext,"PleaseSelectNew")}${targetLocalName}`} {...formItemLayout}>
                  {getFieldDecorator(transferTargetParameterName, {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseSearch") }],
                    initialValue: currentValue
                  })(
                    <AutoComplete
                    dataSource={candidateReferenceList.candidates}
                    onSearch={(value)=>handleTransferSearch(targetComponent,value)}
                    >
                   {candidateReferenceList.candidates.map(item=>{
                return (<Option key={item.id}>{`${item.displayName}(${item.id})`}</Option>);
            })}
                    
                    </AutoComplete>
                  )}
                </Form.Item>
              </Col></Row>
              </Form>

          
        </Modal>)


}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



const internalRenderExtraHeader = (retailStoreOrderLineItem) =>{
	return null
}
const internalRenderExtraFooter = (retailStoreOrderLineItem) =>{
	return null
}
const internalSubListsOf = (cardsData) =>{
	const {id} = cardsData.cardsSource;
	const userContext = null
	return (<Row gutter={24}>

           {cardsData.subItems.sort((x,y)=>x.displayName.localeCompare(y.displayName, 'zh-CN')).map((item)=>(<Col {...topColResponsiveProps} key={item.name}>   
            <Card title={`${item.displayName}(${numeral(item.count).format('0,0')})`}  style={{ width: 180 }}>             
              <p><Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}><FontAwesome name="list"  />&nbsp;{appLocaleName(userContext,"Manage")}</Link>
              
              {item.addFunction&&(<Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}><span className={styles.splitLine}></span><FontAwesome name="plus"  />&nbsp;{appLocaleName(userContext,"Add")}</Link>)}   
              
              </p>         
          </Card> 
            </Col>))}
          </Row>)
}

const internalSummaryOf = (retailStoreOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderLineItem.id}</Description> 
<Description term="订单">{retailStoreOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):retailStoreOrderLineItem.bizOrder.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","retailStoreOrder","requestCandidateBizOrder",
	      "transferToAnotherBizOrder","anotherBizOrderId",retailStoreOrderLineItem.bizOrder?retailStoreOrderLineItem.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="产品ID">{retailStoreOrderLineItem.skuId}</Description> 
<Description term="产品名称">{retailStoreOrderLineItem.skuName}</Description> 
<Description term="金额">{retailStoreOrderLineItem.amount}</Description> 
<Description term="数量">{retailStoreOrderLineItem.quantity}</Description> 
<Description term="测量单位">{retailStoreOrderLineItem.unitOfMeasurement}</Description> 
	
        {buildTransferModal(retailStoreOrderLineItem,targetComponent)}
      </DescriptionList>
	)

}


const renderPermissionSetting = retailStoreOrderLineItem => {
  const {RetailStoreOrderLineItemBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderLineItem}  targetObjectMeta={RetailStoreOrderLineItemBase}/>


}


class RetailStoreOrderLineItemPreference extends Component {

  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:""


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.retailStoreOrderLineItem
    const cardsData = {cardsName:"双链小超订单行项目",cardsFor: "retailStoreOrderLineItem",cardsSource: this.props.retailStoreOrderLineItem,
  		subItems: [
    
      	],
  	};
    //{appLocaleName(userContext,"EveryPartCanBeCustomed")}_features="custom"{appLocaleName(userContext,"Getacustomsample")}
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    /*
    {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
    */
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderPermissionSetting(cardsData.cardsSource)}
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
       
        {subListsOf(cardsData)} 
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreOrderLineItem: state._retailStoreOrderLineItem,
}))(Form.create()(RetailStoreOrderLineItemPreference))

