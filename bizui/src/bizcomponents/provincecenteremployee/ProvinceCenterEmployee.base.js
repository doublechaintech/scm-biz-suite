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
import styles from './ProvinceCenterEmployee.base.less'
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



const menuData = {menuName: window.trans('province_center_employee'), menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('province_center_employee'), menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('province_center_employee.id'),
  name: window.trans('province_center_employee.name'),
  mobile: window.trans('province_center_employee.mobile'),
  email: window.trans('province_center_employee.email'),
  founded: window.trans('province_center_employee.founded'),
  department: window.trans('province_center_employee.department'),
  provinceCenter: window.trans('province_center_employee.province_center'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'provinceCenterEmployee') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(provinceCenterEmployee, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={provinceCenterEmployee.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(provinceCenterEmployee.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={provinceCenterEmployee.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.name}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.mobile}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.email}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.department}><Tag color='blue' title={`${provinceCenterEmployee.department.id}-${provinceCenterEmployee.department.displayName}`}>{provinceCenterEmployee.department==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(provinceCenterEmployee.department.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.provinceCenter}><Tag color='blue' title={`${provinceCenterEmployee.provinceCenter.id}-${provinceCenterEmployee.provinceCenter.displayName}`}>{provinceCenterEmployee.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(provinceCenterEmployee.provinceCenter.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, email, founded, departmentId, provinceCenterId} = formValuesToPack
	const department = {id: departmentId, version: 2^31}
	const provinceCenter = {id: provinceCenterId, version: 2^31}
	const data = {name, mobile, email, founded:moment(founded).valueOf(), department, provinceCenter}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobile, email, founded, department, provinceCenter} = objectToUnpack
	const departmentId = department ? department.id : null
	const provinceCenterId = provinceCenter ? provinceCenter.id : null
	const data = {name, mobile, email, founded:moment(founded), departmentId, provinceCenterId}
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
const ProvinceCenterEmployeeBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ProvinceCenterEmployeeBase

