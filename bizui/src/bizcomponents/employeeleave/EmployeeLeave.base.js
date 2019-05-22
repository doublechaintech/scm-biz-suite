import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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
const renderItemOfList=({employeeLeave,targetComponent})=>{

	
	
	const {EmployeeLeaveService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeLeave.id}</Description> 
<Description term="谁">{employeeLeave.who==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.who.displayName}(${employeeLeave.who.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"谁","employee",EmployeeLeaveService.requestCandidateWho,
	      EmployeeLeaveService.transferToAnotherWho,"anotherWhoId",employeeLeave.who?employeeLeave.who.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="类型">{employeeLeave.type==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.type.displayName}(${employeeLeave.type.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"类型","leaveType",EmployeeLeaveService.requestCandidateType,
	      EmployeeLeaveService.transferToAnotherType,"anotherTypeId",employeeLeave.type?employeeLeave.type.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="请假时长">{employeeLeave.leaveDurationHour}</Description> 
<Description term="备注">{employeeLeave.remark}</Description> 
	
        {buildTransferModal(employeeLeave,targetComponent)}
      </DescriptionList>
	)

}
	



const EmployeeLeaveBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeLeaveBase



