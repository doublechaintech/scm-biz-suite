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
import styles from './LevelOneDepartment.base.less'
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



const menuData = {menuName: window.trans('level_one_department'), menuFor: "levelOneDepartment",
  		subItems: [
  {name: 'levelTwoDepartmentList', displayName: window.mtrans('level_two_department','level_one_department.level_two_department_list',false), type:'levelTwoDepartment',icon:'dice-two',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('level_one_department'), menuFor: "levelOneDepartment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('level_one_department.id'),
  belongsTo: window.trans('level_one_department.belongs_to'),
  name: window.trans('level_one_department.name'),
  description: window.trans('level_one_department.description'),
  manager: window.trans('level_one_department.manager'),
  founded: window.trans('level_one_department.founded'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.manager, debugtype: 'string', dataIndex: 'manager', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(levelOneDepartment, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(levelOneDepartment, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={levelOneDepartment.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(levelOneDepartment.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={levelOneDepartment.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{levelOneDepartment.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{levelOneDepartment.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{levelOneDepartment.description}</Description> 
        <Description term={fieldLabels.manager} style={{wordBreak: 'break-all'}}>{levelOneDepartment.manager}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(levelOneDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, manager, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
<<<<<<< HEAD
	const data = {name, description, manager, founded:moment(founded).valueOf(), belongsTo}
=======
	const data = {name, description, manager, founded, belongsTo}
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description, manager, founded, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
<<<<<<< HEAD
	const data = {name, description, manager, founded:moment(founded), belongsToId}
=======
	const data = {name, description, manager, founded, belongsToId}
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
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
const LevelOneDepartmentBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default LevelOneDepartmentBase

