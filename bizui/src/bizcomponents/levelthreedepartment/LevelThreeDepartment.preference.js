

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
import styles from './LevelThreeDepartment.preference.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
<<<<<<< HEAD
=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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


const internalImageListOf = (levelThreeDepartment) =>{
<<<<<<< HEAD

=======
  const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  const imageList = [
	 ]
  const filteredList = imageList.filter((item)=>item.imageLocation!=null)
  if(filteredList.length===0){
    return null
  }

<<<<<<< HEAD
  return(<Card title='图片列表' className={styles.card}><Row type="flex" justify="start" align="bottom">
=======
  return(<Card title={appLocaleName(userContext,"ImageList")} className={styles.card}><Row type="flex" justify="start" align="bottom">
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  {
      filteredList.map((item,index)=>(<Col span={4} key={index}><ImagePreview imageTitle ={item.title} showTitleUnderImage={true} imageLocation={item.imageLocation} >{item.title}</ImagePreview></Col>))
  }</Row></Card> )

}

const internalSettingListOf = (levelThreeDepartment) =>{
<<<<<<< HEAD

=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	const optionList = [ 
	]
	
  if(optionList.length===0){
    return null
  }
<<<<<<< HEAD
  return(<Card title='状态集合' className={styles.card}>
  	
  	{
  	  optionList.map((item)=><Col key={item.parameterName} span={6} style={{"height":"60px"}}>
       <Switch  title={item.title} checked={item.value} type={item.value?"success":"error"} checkedChildren="是" unCheckedChildren="否" />
=======
  return(<Card title={appLocaleName(userContext,"Switchers")} className={styles.card}>
  	
  	{
  	  optionList.map((item)=><Col key={item.parameterName} span={6} style={{"height":"60px"}}>
       <Switch  title={item.title} checked={item.value} type={item.value?"success":"error"} checkedChildren={appLocaleName(userContext,"Yes")} unCheckedChildren={appLocaleName(userContext,"No")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
       <span style={{"margin":"10px"}}>{item.title}</span>
       </Col>)
  	}


</Card> )
	


}

const internalLargeTextOf = (levelThreeDepartment) =>{

	return null
	

}

/////////////////////////////////////// BUILD FOR TRANSFERRING TO ANOTHER OBJECT////////////////////////////////////////////////

const handleTransferSearch =(targetComponent,filterKey,newRequest)=>{
  const {LevelThreeDepartmentService} = GlobalComponents;

  const parameters = newRequest||targetComponent.state

  const {
 
    candidateServiceName,
    candidateObjectType,
    targetLocalName,
 
  } = parameters

  console.log("current state", parameters)

  const id = "";//not used for now
  const pageNo = 1;
  const candidateReferenceService = LevelThreeDepartmentService[candidateServiceName] 
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
<<<<<<< HEAD
      transferModalVisiable:true,transferModalTitle:"重新分配<"+targetLocalName+">"
=======
      transferModalVisiable:true,transferModalTitle:appLocaleName(userContext,"Reassign")+targetLocalName+">"
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
     
    })

  })

}
<<<<<<< HEAD
//  onClick={()=>showTransferModel(targetComponent,"城市","city","requestCandidateDistrict","transferToAnotherDistrict")} 
=======
//  onClick={()=>showTransferModel(targetComponent,{appLocaleName(userContext,"City")},"city","requestCandidateDistrict","transferToAnotherDistrict")} 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

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

const executeTrans = (levelThreeDepartment,targetComponent) =>{
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
    const id=levelThreeDepartment.id;
    const serviceNameToCall = transferServiceName;

    const payload = {parameters,id,serviceNameToCall}
    
    //targetComponent.setState({transferModalVisiable:false})
    dispatch({type:"_levelThreeDepartment/doJob",payload: payload})

    targetComponent.setState({transferModalVisiable:false})

  })
 

}


const buildTransferModal = (levelThreeDepartment,targetComponent) => {


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
          onOk={()=>executeTrans(levelThreeDepartment,targetComponent)}
          onCancel={()=>hideCloseTrans(targetComponent)}
          
        >

  <Form >
            <Row gutter={16}>

              <Col lg={24} md={24} sm={24}>
<<<<<<< HEAD
                <Form.Item label={`请选择新的${targetLocalName}`} {...formItemLayout}>
                  {getFieldDecorator(transferTargetParameterName, {
                    rules: [{ required: true, message: '请搜索' }],
=======
                <Form.Item label={`${appLocaleName(userContext,"PleaseSelectNew")}${targetLocalName}`} {...formItemLayout}>
                  {getFieldDecorator(transferTargetParameterName, {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseSearch") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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



const internalRenderExtraHeader = (levelThreeDepartment) =>{
	return null
}
const internalRenderExtraFooter = (levelThreeDepartment) =>{
	return null
}
const internalSubListsOf = (cardsData) =>{
	const {id} = cardsData.cardsSource;
<<<<<<< HEAD
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (<Row gutter={24}>

           {cardsData.subItems.sort((x,y)=>x.displayName.localeCompare(y.displayName, 'zh-CN')).map((item)=>(<Col {...topColResponsiveProps} key={item.name}>   
            <Card title={`${item.displayName}(${numeral(item.count).format('0,0')})`}  style={{ width: 180 }}>             
<<<<<<< HEAD
              <p><Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}><FontAwesome name="list"  />&nbsp;管理</Link>
              
              {item.addFunction&&(<Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}><span className={styles.splitLine}></span><FontAwesome name="plus"  />&nbsp;新增</Link>)}   
=======
              <p><Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}><FontAwesome name="list"  />&nbsp;{appLocaleName(userContext,"Manage")}</Link>
              
              {item.addFunction&&(<Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}><span className={styles.splitLine}></span><FontAwesome name="plus"  />&nbsp;{appLocaleName(userContext,"Add")}</Link>)}   
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              
              </p>         
          </Card> 
            </Col>))}
          </Row>)
}

const internalSummaryOf = (levelThreeDepartment,targetComponent) =>{
<<<<<<< HEAD

	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelThreeDepartment.id}</Description> 
<Description term="属于">{levelThreeDepartment.belongsTo==null?"未分配":levelThreeDepartment.belongsTo.displayName}
=======
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelThreeDepartment.id}</Description> 
<Description term="属于">{levelThreeDepartment.belongsTo==null?appLocaleName(userContext,"NotAssigned"):levelThreeDepartment.belongsTo.displayName}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"属于","levelTwoDepartment","requestCandidateBelongsTo",
	      "transferToAnotherBelongsTo","anotherBelongsToId",levelThreeDepartment.belongsTo?levelThreeDepartment.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="名称">{levelThreeDepartment.name}</Description> 
<Description term="描述">{levelThreeDepartment.description}</Description> 
<Description term="成立">{ moment(levelThreeDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(levelThreeDepartment,targetComponent)}
      </DescriptionList>
	)

}


const renderPermissionSetting = levelThreeDepartment => {
  const {LevelThreeDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={levelThreeDepartment}  targetObjectMeta={LevelThreeDepartmentBase}/>


}


class LevelThreeDepartmentPreference extends Component {

  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
<<<<<<< HEAD
    candidateObjectType:"city",
    targetLocalName:"城市",
=======
    candidateObjectType:"",
    targetLocalName:"",
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:""


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, employeeCount } = this.props.levelThreeDepartment
    const cardsData = {cardsName:"三级部门",cardsFor: "levelThreeDepartment",cardsSource: this.props.levelThreeDepartment,
  		subItems: [
    
      	],
  	};
<<<<<<< HEAD
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
    //{appLocaleName(userContext,"EveryPartCanBeCustomed")}_features="custom"{appLocaleName(userContext,"Getacustomsample")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
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
  levelThreeDepartment: state._levelThreeDepartment,
}))(Form.create()(LevelThreeDepartmentPreference))

