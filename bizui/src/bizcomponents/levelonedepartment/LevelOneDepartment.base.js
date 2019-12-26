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
const menuData = {menuName:"一级部门", menuFor: "levelOneDepartment",
  		subItems: [
  {name: 'levelTwoDepartmentList', displayName:'二级部门', icon:'dice-two',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('level_one_department'), menuFor: "levelOneDepartment",
  		subItems: [
  {name: 'levelTwoDepartmentList', displayName: window.mtrans('level_two_department','level_one_department.level_two_department_list',false), type:'levelTwoDepartment',icon:'dice-two',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('level_one_department'), menuFor: "levelOneDepartment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('level_one_department.id'),
  belongsTo: window.trans('level_one_department.belongs_to'),
  name: window.trans('level_one_department.name'),
  description: window.trans('level_one_department.description'),
  managerName: window.trans('level_one_department.manager_name'),
  founded: window.trans('level_one_department.founded'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.managerName, debugtype: 'string', dataIndex: 'managerName', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(levelOneDepartment,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneDepartment.id}>
	
      <DescriptionList  key={levelOneDepartment.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{levelOneDepartment.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{levelOneDepartment.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{levelOneDepartment.description}</Description> 
        <Description term={fieldLabels.managerName} style={{wordBreak: 'break-all'}}>{levelOneDepartment.managerName}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(levelOneDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"一级部门", menuFor: "levelOneDepartment",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  belongsTo: '属于',
  name: '名称',
  description: '描述',
  manager: '经理',
  founded: '成立',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.manager, debugtype: 'string', dataIndex: 'manager', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelOneDepartment,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneDepartment.id}>
	
      <DescriptionList  key={levelOneDepartment.id} size="small" col="4">
        <Description term="序号">{levelOneDepartment.id}</Description> 
        <Description term="名称">{levelOneDepartment.name}</Description> 
        <Description term="描述">{levelOneDepartment.description}</Description> 
        <Description term="经理">{levelOneDepartment.manager}</Description> 
        <Description term="成立"><div>{ moment(levelOneDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, manager, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, description, manager, founded, belongsTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description, manager, founded, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, description, manager, founded, belongsToId}
	return data
}

const LevelOneDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, managerName, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, description, managerName, founded, belongsTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description, managerName, founded, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, description, managerName, founded, belongsToId}
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
const LevelOneDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LevelOneDepartmentBase



