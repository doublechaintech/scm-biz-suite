import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"请假记录", menuFor: "employeeLeave",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  type: '类型',
  leaveDurationHour: '请假时长',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.who, dataIndex: 'who', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.leaveDurationHour, debugtype: 'int', dataIndex: 'leaveDurationHour', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '15',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeLeave,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employeeLeave.id}>
	
	<DescriptionList  key={employeeLeave.id} size="small" col="4">
<Description term="序号">{employeeLeave.id}</Description> 
<Description term="谁">{employeeLeave.who==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.who.displayName}(${employeeLeave.who.id})`}
</Description>
<Description term="类型">{employeeLeave.type==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.type.displayName}(${employeeLeave.type.id})`}
</Description>
<Description term="请假时长">{employeeLeave.leaveDurationHour}</Description> 
<Description term="备注">{employeeLeave.remark}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeLeaveBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeLeaveBase



