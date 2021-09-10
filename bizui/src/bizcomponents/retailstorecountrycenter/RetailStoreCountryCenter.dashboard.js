

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreCountryCenter.dashboard.less'
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

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(retailStoreCountryCenter)=>{return [
	 ]}

const internalImageListOf = (retailStoreCountryCenter) =>defaultImageListOf(retailStoreCountryCenter,imageList)

const optionList =(retailStoreCountryCenter)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStoreCountryCenter) =>defaultSettingListOf(retailStoreCountryCenter, optionList)
const internalLargeTextOf = (retailStoreCountryCenter) =>{

	return null


}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


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
      <Link to={`/retailStoreCountryCenter/${targetComponent.props.retailStoreCountryCenter.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStoreCountryCenter/${targetComponent.props.retailStoreCountryCenter.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{


  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const retailStoreCountryCenter = cardsData.cardsSource
	const {RetailStoreCountryCenterService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.name}</Description> 
<Description term="服务号码" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.serviceNumber}</Description> 
<Description term="成立">{ moment(retailStoreCountryCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="网站" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.webSite}</Description> 
<Description term="地址" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.address}</Description> 
<Description term="由" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.operatedBy}</Description> 
<Description term="法定代表人" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.legalRepresentative}</Description> 
<Description term="描述" style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.description}</Description> 

       
      </DescriptionList>
      <div>{quickFunctions(cardsData)}</div>
      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


}


const internalQuickFunctions = defaultQuickFunctions

class RetailStoreCountryCenterDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",
    defaultType: 'retailStoreCountryCenter'


  }
  componentDidMount() {

  }


  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, catalogListMetaInfo, retailStoreProvinceCenterListMetaInfo, retailStoreListMetaInfo, retailStoreMemberListMetaInfo, goodsSupplierListMetaInfo, supplyOrderListMetaInfo, retailStoreOrderListMetaInfo, warehouseListMetaInfo, transportFleetListMetaInfo, accountSetListMetaInfo, levelOneDepartmentListMetaInfo, skillTypeListMetaInfo, responsibilityTypeListMetaInfo, terminationReasonListMetaInfo, terminationTypeListMetaInfo, occupationTypeListMetaInfo, leaveTypeListMetaInfo, salaryGradeListMetaInfo, interviewTypeListMetaInfo, trainingCourseTypeListMetaInfo, publicHolidayListMetaInfo, employeeListMetaInfo, instructorListMetaInfo, companyTrainingListMetaInfo, catalogCount, retailStoreProvinceCenterCount, retailStoreCount, retailStoreMemberCount, goodsSupplierCount, supplyOrderCount, retailStoreOrderCount, warehouseCount, transportFleetCount, accountSetCount, levelOneDepartmentCount, skillTypeCount, responsibilityTypeCount, terminationReasonCount, terminationTypeCount, occupationTypeCount, leaveTypeCount, salaryGradeCount, interviewTypeCount, trainingCourseTypeCount, publicHolidayCount, employeeCount, instructorCount, companyTrainingCount } = this.props.retailStoreCountryCenter
    if(!this.props.retailStoreCountryCenter.class){
      return null
    }
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('retail_store_country_center'),cardsFor: "retailStoreCountryCenter",
    	cardsSource: this.props.retailStoreCountryCenter,returnURL,displayName,
  		subItems: [
{name: 'catalogList', displayName: window.mtrans('catalog','retail_store_country_center.catalog_list',false) ,viewGroup:'产品管理', type:'catalog',count:catalogCount,addFunction: true, role: 'catalog', metaInfo: catalogListMetaInfo, renderItem: GlobalComponents.CatalogBase.renderItemOfList},
{name: 'retailStoreProvinceCenterList', displayName: window.mtrans('retail_store_province_center','retail_store_country_center.retail_store_province_center_list',false) ,viewGroup:'组织机构', type:'retailStoreProvinceCenter',count:retailStoreProvinceCenterCount,addFunction: true, role: 'retailStoreProvinceCenter', metaInfo: retailStoreProvinceCenterListMetaInfo, renderItem: GlobalComponents.RetailStoreProvinceCenterBase.renderItemOfList},
{name: 'retailStoreList', displayName: window.mtrans('retail_store','retail_store_country_center.retail_store_list',false) ,viewGroup:'加盟管理', type:'retailStore',count:retailStoreCount,addFunction: true, role: 'retailStore', metaInfo: retailStoreListMetaInfo, renderItem: GlobalComponents.RetailStoreBase.renderItemOfList},
{name: 'retailStoreMemberList', displayName: window.mtrans('retail_store_member','retail_store_country_center.retail_store_member_list',false) ,viewGroup:'会员管理', type:'retailStoreMember',count:retailStoreMemberCount,addFunction: true, role: 'retailStoreMember', metaInfo: retailStoreMemberListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberBase.renderItemOfList},
{name: 'goodsSupplierList', displayName: window.mtrans('goods_supplier','retail_store_country_center.goods_supplier_list',false) ,viewGroup:'供应管理', type:'goodsSupplier',count:goodsSupplierCount,addFunction: true, role: 'goodsSupplier', metaInfo: goodsSupplierListMetaInfo, renderItem: GlobalComponents.GoodsSupplierBase.renderItemOfList},
{name: 'supplyOrderList', displayName: window.mtrans('supply_order','retail_store_country_center.supply_order_list',false) ,viewGroup:'供应管理', type:'supplyOrder',count:supplyOrderCount,addFunction: true, role: 'supplyOrder', metaInfo: supplyOrderListMetaInfo, renderItem: GlobalComponents.SupplyOrderBase.renderItemOfList},
{name: 'retailStoreOrderList', displayName: window.mtrans('retail_store_order','retail_store_country_center.retail_store_order_list',false) ,viewGroup:'销售管理', type:'retailStoreOrder',count:retailStoreOrderCount,addFunction: true, role: 'retailStoreOrder', metaInfo: retailStoreOrderListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderBase.renderItemOfList},
{name: 'warehouseList', displayName: window.mtrans('warehouse','retail_store_country_center.warehouse_list',false) ,viewGroup:'仓配运一体化', type:'warehouse',count:warehouseCount,addFunction: true, role: 'warehouse', metaInfo: warehouseListMetaInfo, renderItem: GlobalComponents.WarehouseBase.renderItemOfList},
{name: 'transportFleetList', displayName: window.mtrans('transport_fleet','retail_store_country_center.transport_fleet_list',false) ,viewGroup:'仓配运一体化', type:'transportFleet',count:transportFleetCount,addFunction: true, role: 'transportFleet', metaInfo: transportFleetListMetaInfo, renderItem: GlobalComponents.TransportFleetBase.renderItemOfList},
{name: 'accountSetList', displayName: window.mtrans('account_set','retail_store_country_center.account_set_list',false) ,viewGroup:'财务管理', type:'accountSet',count:accountSetCount,addFunction: true, role: 'accountSet', metaInfo: accountSetListMetaInfo, renderItem: GlobalComponents.AccountSetBase.renderItemOfList},
{name: 'levelOneDepartmentList', displayName: window.mtrans('level_one_department','retail_store_country_center.level_one_department_list',false) ,viewGroup:'组织机构', type:'levelOneDepartment',count:levelOneDepartmentCount,addFunction: true, role: 'levelOneDepartment', metaInfo: levelOneDepartmentListMetaInfo, renderItem: GlobalComponents.LevelOneDepartmentBase.renderItemOfList},
{name: 'employeeList', displayName: window.mtrans('employee','retail_store_country_center.employee_list',false) ,viewGroup:'人力资源', type:'employee',count:employeeCount,addFunction: true, role: 'employee', metaInfo: employeeListMetaInfo, renderItem: GlobalComponents.EmployeeBase.renderItemOfList},
{name: 'instructorList', displayName: window.mtrans('instructor','retail_store_country_center.instructor_list',false) ,viewGroup:'人力资源', type:'instructor',count:instructorCount,addFunction: true, role: 'instructor', metaInfo: instructorListMetaInfo, renderItem: GlobalComponents.InstructorBase.renderItemOfList},
{name: 'companyTrainingList', displayName: window.mtrans('company_training','retail_store_country_center.company_training_list',false) ,viewGroup:'人力资源', type:'companyTraining',count:companyTrainingCount,addFunction: true, role: 'companyTraining', metaInfo: companyTrainingListMetaInfo, renderItem: GlobalComponents.CompanyTrainingBase.renderItemOfList},

      	],
   		subSettingItems: [
{name: 'skillTypeList', displayName: window.mtrans('skill_type','retail_store_country_center.skill_type_list',false),type:'skillType',count:skillTypeCount,addFunction: true, role: 'skillType', metaInfo: skillTypeListMetaInfo, renderItem: GlobalComponents.SkillTypeBase.renderItemOfList},
{name: 'responsibilityTypeList', displayName: window.mtrans('responsibility_type','retail_store_country_center.responsibility_type_list',false),type:'responsibilityType',count:responsibilityTypeCount,addFunction: true, role: 'responsibilityType', metaInfo: responsibilityTypeListMetaInfo, renderItem: GlobalComponents.ResponsibilityTypeBase.renderItemOfList},
{name: 'terminationReasonList', displayName: window.mtrans('termination_reason','retail_store_country_center.termination_reason_list',false),type:'terminationReason',count:terminationReasonCount,addFunction: true, role: 'terminationReason', metaInfo: terminationReasonListMetaInfo, renderItem: GlobalComponents.TerminationReasonBase.renderItemOfList},
{name: 'terminationTypeList', displayName: window.mtrans('termination_type','retail_store_country_center.termination_type_list',false),type:'terminationType',count:terminationTypeCount,addFunction: true, role: 'terminationType', metaInfo: terminationTypeListMetaInfo, renderItem: GlobalComponents.TerminationTypeBase.renderItemOfList},
{name: 'occupationTypeList', displayName: window.mtrans('occupation_type','retail_store_country_center.occupation_type_list',false),type:'occupationType',count:occupationTypeCount,addFunction: true, role: 'occupationType', metaInfo: occupationTypeListMetaInfo, renderItem: GlobalComponents.OccupationTypeBase.renderItemOfList},
{name: 'leaveTypeList', displayName: window.mtrans('leave_type','retail_store_country_center.leave_type_list',false),type:'leaveType',count:leaveTypeCount,addFunction: true, role: 'leaveType', metaInfo: leaveTypeListMetaInfo, renderItem: GlobalComponents.LeaveTypeBase.renderItemOfList},
{name: 'salaryGradeList', displayName: window.mtrans('salary_grade','retail_store_country_center.salary_grade_list',false),type:'salaryGrade',count:salaryGradeCount,addFunction: true, role: 'salaryGrade', metaInfo: salaryGradeListMetaInfo, renderItem: GlobalComponents.SalaryGradeBase.renderItemOfList},
{name: 'interviewTypeList', displayName: window.mtrans('interview_type','retail_store_country_center.interview_type_list',false),type:'interviewType',count:interviewTypeCount,addFunction: true, role: 'interviewType', metaInfo: interviewTypeListMetaInfo, renderItem: GlobalComponents.InterviewTypeBase.renderItemOfList},
{name: 'trainingCourseTypeList', displayName: window.mtrans('training_course_type','retail_store_country_center.training_course_type_list',false),type:'trainingCourseType',count:trainingCourseTypeCount,addFunction: true, role: 'trainingCourseType', metaInfo: trainingCourseTypeListMetaInfo, renderItem: GlobalComponents.TrainingCourseTypeBase.renderItemOfList},
{name: 'publicHolidayList', displayName: window.mtrans('public_holiday','retail_store_country_center.public_holiday_list',false),type:'publicHoliday',count:publicHolidayCount,addFunction: true, role: 'publicHoliday', metaInfo: publicHolidayListMetaInfo, renderItem: GlobalComponents.PublicHolidayBase.renderItemOfList},

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
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >


       
     <Col span={24} style={{marginRight:"20px", backgroundColor: "white"}}>
      {renderTagCloud(cardsData)}

      {imageListOf(cardsData.cardsSource)}
      {renderAnalytics(cardsData.cardsSource)}
      {settingListOf(cardsData.cardsSource)}

	   </Col>

		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  retailStoreCountryCenter: state._retailStoreCountryCenter,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(RetailStoreCountryCenterDashboard))

