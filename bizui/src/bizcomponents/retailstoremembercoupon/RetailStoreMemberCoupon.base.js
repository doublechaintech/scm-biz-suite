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


const menuData = {menuName:"生超会员优惠券", menuFor: "retailStoreMemberCoupon",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  number: '数',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({retailStoreMemberCoupon,targetComponent})=>{

	
	
	const {RetailStoreMemberCouponService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMemberCoupon.id}</Description> 
<Description term="名称">{retailStoreMemberCoupon.name}</Description> 
<Description term="业主">{retailStoreMemberCoupon.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberCoupon.owner.displayName}(${retailStoreMemberCoupon.owner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"业主","retailStoreMember",RetailStoreMemberCouponService.requestCandidateOwner,
	      RetailStoreMemberCouponService.transferToAnotherOwner,"anotherOwnerId",retailStoreMemberCoupon.owner?retailStoreMemberCoupon.owner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="数">{retailStoreMemberCoupon.number}</Description> 
<Description term="最后更新时间">{ moment(retailStoreMemberCoupon.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(retailStoreMemberCoupon,targetComponent)}
      </DescriptionList>
	)

}
	



const RetailStoreMemberCouponBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreMemberCouponBase



