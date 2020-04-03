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
import styles from './Instructor.base.less'
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



const menuData = {menuName: window.trans('instructor'), menuFor: "instructor",
  		subItems: [
  {name: 'companyTrainingList', displayName: window.mtrans('company_training','instructor.company_training_list',false), type:'companyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('instructor'), menuFor: "instructor",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('instructor.id'),
  title: window.trans('instructor.title'),
  familyName: window.trans('instructor.family_name'),
  givenName: window.trans('instructor.given_name'),
  cellPhone: window.trans('instructor.cell_phone'),
  email: window.trans('instructor.email'),
  company: window.trans('instructor.company'),
  introduction: window.trans('instructor.introduction'),
  lastUpdateTime: window.trans('instructor.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'instructor') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.familyName, debugtype: 'string', dataIndex: 'familyName', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.givenName, debugtype: 'string', dataIndex: 'givenName', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cellPhone, debugtype: 'string_china_mobile_phone', dataIndex: 'cellPhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.introduction, debugtype: 'string', dataIndex: 'introduction', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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

const renderReferenceItem=(value, targetComponent)=>{
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
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(instructor, targetComponent, columCount)=>{
  
  if(!instructor){
  	return null
  }
  if(!instructor.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`instructor-${instructor.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(instructor.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={instructor.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{instructor.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{instructor.title}</Description> 
        <Description term={fieldLabels.familyName} style={{wordBreak: 'break-all'}}>{instructor.familyName}</Description> 
        <Description term={fieldLabels.givenName} style={{wordBreak: 'break-all'}}>{instructor.givenName}</Description> 
        <Description term={fieldLabels.cellPhone} style={{wordBreak: 'break-all'}}>{instructor.cellPhone}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{instructor.email}</Description> 
        <Description term={fieldLabels.introduction} style={{wordBreak: 'break-all'}}>{instructor.introduction}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(instructor.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, familyName, givenName, cellPhone, email, introduction, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {title, familyName, givenName, cellPhone, email, introduction, company}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, familyName, givenName, cellPhone, email, introduction, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {title, familyName, givenName, cellPhone, email, introduction, companyId}
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
const InstructorBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default InstructorBase

