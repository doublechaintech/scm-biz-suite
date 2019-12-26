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
const menuData = {menuName:"三级部门", menuFor: "levelThreeDepartment",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('level_three_department'), menuFor: "levelThreeDepartment",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','level_three_department.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('level_three_department'), menuFor: "levelThreeDepartment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('level_three_department.id'),
  belongsTo: window.trans('level_three_department.belongs_to'),
  name: window.trans('level_three_department.name'),
  description: window.trans('level_three_department.description'),
  founded: window.trans('level_three_department.founded'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelThreeDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(levelThreeDepartment,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelThreeDepartment.id}>
	
      <DescriptionList  key={levelThreeDepartment.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{levelThreeDepartment.id}</Description> 
        <Description term={fieldLabels.belongsTo}><div>{levelThreeDepartment.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${levelThreeDepartment.belongsTo.displayName}(${levelThreeDepartment.belongsTo.id})`}
        </div></Description>
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{levelThreeDepartment.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{levelThreeDepartment.description}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(levelThreeDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"三级部门", menuFor: "levelThreeDepartment",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  belongsTo: '属于',
  name: '名称',
  description: '描述',
  founded: '成立',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelThreeDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelThreeDepartment,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelThreeDepartment.id}>
	
      <DescriptionList  key={levelThreeDepartment.id} size="small" col="4">
        <Description term="序号">{levelThreeDepartment.id}</Description> 
        <Description term="属于"><div>{levelThreeDepartment.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${levelThreeDepartment.belongsTo.displayName}(${levelThreeDepartment.belongsTo.id})`}
        </div></Description>
        <Description term="名称">{levelThreeDepartment.name}</Description> 
        <Description term="描述">{levelThreeDepartment.description}</Description> 
        <Description term="成立"><div>{ moment(levelThreeDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, description, founded, belongsTo}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, description, founded, belongsTo}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description, founded, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, description, founded, belongsToId}
	return data
}
<<<<<<< HEAD

const LevelThreeDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const LevelThreeDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LevelThreeDepartmentBase



