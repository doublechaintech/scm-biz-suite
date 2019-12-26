import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"讲师", menuFor: "instructor",
  		subItems: [
  {name: 'companyTrainingList', displayName:'公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('instructor'), menuFor: "instructor",
  		subItems: [
  {name: 'companyTrainingList', displayName: window.mtrans('company_training','instructor.company_training_list',false), type:'companyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

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

const renderItemOfList=(instructor,targetComponent)=>{

  const userContext = null
  return (
    <div key={instructor.id}>
	
      <DescriptionList  key={instructor.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{instructor.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{instructor.title}</Description> 
        <Description term={fieldLabels.familyName} style={{wordBreak: 'break-all'}}>{instructor.familyName}</Description> 
        <Description term={fieldLabels.givenName} style={{wordBreak: 'break-all'}}>{instructor.givenName}</Description> 
        <Description term={fieldLabels.cellPhone} style={{wordBreak: 'break-all'}}>{instructor.cellPhone}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{instructor.email}</Description> 
        <Description term={fieldLabels.introduction} style={{wordBreak: 'break-all'}}>{instructor.introduction}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(instructor.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"讲师", menuFor: "instructor",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  title: '头衔',
  familyName: '姓',
  givenName: '名',
  cellPhone: '手机',
  email: '电子邮件',
  company: '公司',
  introduction: '介绍',
  lastUpdateTime: '最后更新时间',

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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(instructor,targetComponent)=>{

  const userContext = null
  return (
    <div key={instructor.id}>
	
      <DescriptionList  key={instructor.id} size="small" col="4">
        <Description term="序号">{instructor.id}</Description> 
        <Description term="头衔">{instructor.title}</Description> 
        <Description term="姓">{instructor.familyName}</Description> 
        <Description term="名">{instructor.givenName}</Description> 
        <Description term="手机">{instructor.cellPhone}</Description> 
        <Description term="电子邮件">{instructor.email}</Description> 
        <Description term="介绍">{instructor.introduction}</Description> 
        <Description term="最后更新时间"><div>{ moment(instructor.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, familyName, givenName, cellPhone, email, introduction, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {title, familyName, givenName, cellPhone, email, introduction, company}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, familyName, givenName, cellPhone, email, introduction, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {title, familyName, givenName, cellPhone, email, introduction, company}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, familyName, givenName, cellPhone, email, introduction, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {title, familyName, givenName, cellPhone, email, introduction, companyId}
	return data
}
<<<<<<< HEAD

const InstructorBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
const InstructorBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default InstructorBase



