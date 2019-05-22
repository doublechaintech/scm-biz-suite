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


const menuData = {menuName:"雇佣终止", menuFor: "termination",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  reason: '原因',
  type: '类型',
  comment: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'termination') , sorter: true },
  { title: fieldLabels.reason, dataIndex: 'reason', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({termination,targetComponent})=>{

	
	
	const {TerminationService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{termination.id}</Description> 
<Description term="原因">{termination.reason==null?appLocaleName(userContext,"NotAssigned"):`${termination.reason.displayName}(${termination.reason.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"原因","terminationReason",TerminationService.requestCandidateReason,
	      TerminationService.transferToAnotherReason,"anotherReasonId",termination.reason?termination.reason.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="类型">{termination.type==null?appLocaleName(userContext,"NotAssigned"):`${termination.type.displayName}(${termination.type.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"类型","terminationType",TerminationService.requestCandidateType,
	      TerminationService.transferToAnotherType,"anotherTypeId",termination.type?termination.type.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="评论">{termination.comment}</Description> 
	
        {buildTransferModal(termination,targetComponent)}
      </DescriptionList>
	)

}
	



const TerminationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TerminationBase



