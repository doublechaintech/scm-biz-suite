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


const menuData = {menuName:"原始凭证的审核", menuFor: "originalVoucherAuditing",
  		subItems: [
  {name: 'originalVoucherList', displayName:'原始凭证', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  comments: '评论',
  makeDate: '制造日期',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'originalVoucherAuditing') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(originalVoucherAuditing,targetComponent)=>{

  const userContext = null
  return (
    <div key={originalVoucherAuditing.id}>
	
      <DescriptionList  key={originalVoucherAuditing.id} size="small" col="4">
        <Description term="序号">{originalVoucherAuditing.id}</Description> 
        <Description term="谁">{originalVoucherAuditing.who}</Description> 
        <Description term="评论">{originalVoucherAuditing.comments}</Description> 
        <Description term="制造日期"><div>{ moment(originalVoucherAuditing.makeDate).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const OriginalVoucherAuditingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default OriginalVoucherAuditingBase



