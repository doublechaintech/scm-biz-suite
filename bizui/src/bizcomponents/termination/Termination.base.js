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
const menuData = {menuName:"雇佣终止", menuFor: "termination",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('termination'), menuFor: "termination",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','termination.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"雇佣终止", menuFor: "termination",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  reason: '原因',
  type: '类型',
  comment: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'termination') , sorter: true },
  { title: fieldLabels.reason, dataIndex: 'reason', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(termination,targetComponent)=>{

  const userContext = null
  return (
    <div key={termination.id}>
	
      <DescriptionList  key={termination.id} size="small" col="4">
        <Description term="序号">{termination.id}</Description> 
        <Description term="原因"><div>{termination.reason==null?appLocaleName(userContext,"NotAssigned"):`${termination.reason.displayName}(${termination.reason.id})`}
        </div></Description>
        <Description term="类型"><div>{termination.type==null?appLocaleName(userContext,"NotAssigned"):`${termination.type.displayName}(${termination.type.id})`}
        </div></Description>
        <Description term="评论">{termination.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {comment, reasonId, typeId} = formValuesToPack
	const reason = {id: reasonId, version: 2^31}
	const type = {id: typeId, version: 2^31}
	const data = {comment, reason, type}
	return data
}
=======

const settingMenuData = {menuName: window.trans('termination'), menuFor: "termination",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('termination.id'),
  reason: window.trans('termination.reason'),
  type: window.trans('termination.type'),
  comment: window.trans('termination.comment'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'termination') , sorter: true },
  { title: fieldLabels.reason, dataIndex: 'reason', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '8',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(termination,targetComponent)=>{

  const userContext = null
  return (
    <div key={termination.id}>
	
      <DescriptionList  key={termination.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{termination.id}</Description> 
        <Description term={fieldLabels.reason}><div>{termination.reason==null?appLocaleName(userContext,"NotAssigned"):`${termination.reason.displayName}(${termination.reason.id})`}
        </div></Description>
        <Description term={fieldLabels.type}><div>{termination.type==null?appLocaleName(userContext,"NotAssigned"):`${termination.type.displayName}(${termination.type.id})`}
        </div></Description>
        <Description term={fieldLabels.comment} style={{wordBreak: 'break-all'}}>{termination.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {comment, reasonId, typeId} = formValuesToPack
	const reason = {id: reasonId, version: 2^31}
	const type = {id: typeId, version: 2^31}
	const data = {comment, reason, type}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {comment, reason, type} = objectToUnpack
	const reasonId = reason ? reason.id : null
	const typeId = type ? type.id : null
	const data = {comment, reasonId, typeId}
	return data
}
<<<<<<< HEAD

const TerminationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TerminationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TerminationBase



