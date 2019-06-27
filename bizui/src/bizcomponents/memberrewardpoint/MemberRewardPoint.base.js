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


const menuData = {menuName:"会员奖励点", menuFor: "memberRewardPoint",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  point: '点',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.point, debugtype: 'int', dataIndex: 'point', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({memberRewardPoint,targetComponent})=>{

	
	
	const {MemberRewardPointService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{memberRewardPoint.id}</Description> 
<Description term="名称">{memberRewardPoint.name}</Description> 
<Description term="点">{memberRewardPoint.point}</Description> 
<Description term="业主">{memberRewardPoint.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberRewardPoint.owner.displayName}(${memberRewardPoint.owner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"业主","retailStoreMember",MemberRewardPointService.requestCandidateOwner,
	      MemberRewardPointService.transferToAnotherOwner,"anotherOwnerId",memberRewardPoint.owner?memberRewardPoint.owner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(memberRewardPoint,targetComponent)}
      </DescriptionList>
	)

}
	



const MemberRewardPointBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default MemberRewardPointBase



