import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './RetailStoreCountryCenter.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('retail_store_country_center'), menuFor: "retailStoreCountryCenter",
  		subItems: [
  {name: 'catalogList', displayName: window.mtrans('catalog','retail_store_country_center.catalog_list',false), type:'catalog',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '产品管理'},
  {name: 'retailStoreProvinceCenterList', displayName: window.mtrans('retail_store_province_center','retail_store_country_center.retail_store_province_center_list',false), type:'retailStoreProvinceCenter',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '组织机构'},
  {name: 'retailStoreList', displayName: window.mtrans('retail_store','retail_store_country_center.retail_store_list',false), type:'retailStore',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '加盟管理'},
  {name: 'retailStoreMemberList', displayName: window.mtrans('retail_store_member','retail_store_country_center.retail_store_member_list',false), type:'retailStoreMember',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '会员管理'},
  {name: 'goodsSupplierList', displayName: window.mtrans('goods_supplier','retail_store_country_center.goods_supplier_list',false), type:'goodsSupplier',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '供应管理'},
  {name: 'supplyOrderList', displayName: window.mtrans('supply_order','retail_store_country_center.supply_order_list',false), type:'supplyOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '供应管理'},
  {name: 'retailStoreOrderList', displayName: window.mtrans('retail_store_order','retail_store_country_center.retail_store_order_list',false), type:'retailStoreOrder',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '销售管理'},
  {name: 'warehouseList', displayName: window.mtrans('warehouse','retail_store_country_center.warehouse_list',false), type:'warehouse',icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '仓配运一体化'},
  {name: 'transportFleetList', displayName: window.mtrans('transport_fleet','retail_store_country_center.transport_fleet_list',false), type:'transportFleet',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '仓配运一体化'},
  {name: 'accountSetList', displayName: window.mtrans('account_set','retail_store_country_center.account_set_list',false), type:'accountSet',icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '财务管理'},
  {name: 'levelOneDepartmentList', displayName: window.mtrans('level_one_department','retail_store_country_center.level_one_department_list',false), type:'levelOneDepartment',icon:'bone',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '组织机构'},
  {name: 'employeeList', displayName: window.mtrans('employee','retail_store_country_center.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'instructorList', displayName: window.mtrans('instructor','retail_store_country_center.instructor_list',false), type:'instructor',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'companyTrainingList', displayName: window.mtrans('company_training','retail_store_country_center.company_training_list',false), type:'companyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  
  		],
}


const settingMenuData = {menuName: window.trans('retail_store_country_center'), menuFor: "retailStoreCountryCenter",
  		subItems: [
  {name: 'skillTypeList', displayName: window.mtrans('skill_type','retail_store_country_center.skill_type_list',false), type:'skillType', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'responsibilityTypeList', displayName: window.mtrans('responsibility_type','retail_store_country_center.responsibility_type_list',false), type:'responsibilityType', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'terminationReasonList', displayName: window.mtrans('termination_reason','retail_store_country_center.termination_reason_list',false), type:'terminationReason', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'terminationTypeList', displayName: window.mtrans('termination_type','retail_store_country_center.termination_type_list',false), type:'terminationType', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'occupationTypeList', displayName: window.mtrans('occupation_type','retail_store_country_center.occupation_type_list',false), type:'occupationType', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'leaveTypeList', displayName: window.mtrans('leave_type','retail_store_country_center.leave_type_list',false), type:'leaveType', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'salaryGradeList', displayName: window.mtrans('salary_grade','retail_store_country_center.salary_grade_list',false), type:'salaryGrade', icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'interviewTypeList', displayName: window.mtrans('interview_type','retail_store_country_center.interview_type_list',false), type:'interviewType', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'trainingCourseTypeList', displayName: window.mtrans('training_course_type','retail_store_country_center.training_course_type_list',false), type:'trainingCourseType', icon:'discourse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'publicHolidayList', displayName: window.mtrans('public_holiday','retail_store_country_center.public_holiday_list',false), type:'publicHoliday', icon:'galactic-republic',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_country_center.id'),
  name: window.trans('retail_store_country_center.name'),
  serviceNumber: window.trans('retail_store_country_center.service_number'),
  founded: window.trans('retail_store_country_center.founded'),
  webSite: window.trans('retail_store_country_center.web_site'),
  address: window.trans('retail_store_country_center.address'),
  operatedBy: window.trans('retail_store_country_center.operated_by'),
  legalRepresentative: window.trans('retail_store_country_center.legal_representative'),
  description: window.trans('retail_store_country_center.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'retailStoreCountryCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.serviceNumber, debugtype: 'string', dataIndex: 'serviceNumber', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.webSite, debugtype: 'string_url', dataIndex: 'webSite', width: '36',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.operatedBy, debugtype: 'string', dataIndex: 'operatedBy', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.legalRepresentative, debugtype: 'string', dataIndex: 'legalRepresentative', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	
	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}

const renderItemOfList=(retailStoreCountryCenter, targetComponent, columCount, listName)=>{
  
  if(!retailStoreCountryCenter){
  	return null
  }
  if(!retailStoreCountryCenter.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`${listName}-${retailStoreCountryCenter.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(retailStoreCountryCenter.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={retailStoreCountryCenter.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.name}</Description> 
        <Description term={fieldLabels.serviceNumber} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.serviceNumber}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(retailStoreCountryCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.webSite} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.webSite}</Description> 
        <Description term={fieldLabels.address} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.address}</Description> 
        <Description term={fieldLabels.operatedBy} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.operatedBy}</Description> 
        <Description term={fieldLabels.legalRepresentative} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.legalRepresentative}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{retailStoreCountryCenter.description}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, serviceNumber, founded, webSite, address, operatedBy, legalRepresentative, description} = formValuesToPack

	const data = {name, serviceNumber, founded:moment(founded).valueOf(), webSite, address, operatedBy, legalRepresentative, description}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, serviceNumber, founded, webSite, address, operatedBy, legalRepresentative, description} = objectToUnpack

	const data = {name, serviceNumber, founded:moment(founded), webSite, address, operatedBy, legalRepresentative, description}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const RetailStoreCountryCenterBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default RetailStoreCountryCenterBase

