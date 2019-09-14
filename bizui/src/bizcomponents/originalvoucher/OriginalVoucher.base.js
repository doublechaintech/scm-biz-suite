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


const menuData = {menuName:"原始凭证", menuFor: "originalVoucher",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  title: '头衔',
  madeBy: '由',
  receivedBy: '受',
  voucherType: '凭证类型',
  voucherImage: '凭证图像',
  belongsTo: '属于',
  creation: '创建',
  confirmation: '确认',
  auditing: '审计',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'originalVoucher') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.madeBy, debugtype: 'string', dataIndex: 'madeBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.receivedBy, debugtype: 'string', dataIndex: 'receivedBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherType, debugtype: 'string', dataIndex: 'voucherType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherImage, dataIndex: 'voucherImage', render: (text, record) => renderImageCell(text,record,'凭证图像') },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.auditing, dataIndex: 'auditing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(originalVoucher,targetComponent)=>{

  const userContext = null
  return (
    <div key={originalVoucher.id}>
	
      <DescriptionList  key={originalVoucher.id} size="small" col="4">
        <Description term="序号">{originalVoucher.id}</Description> 
        <Description term="头衔">{originalVoucher.title}</Description> 
        <Description term="由">{originalVoucher.madeBy}</Description> 
        <Description term="受">{originalVoucher.receivedBy}</Description> 
        <Description term="凭证类型">{originalVoucher.voucherType}</Description> 
        <Description term="属于"><div>{originalVoucher.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${originalVoucher.belongsTo.displayName}(${originalVoucher.belongsTo.id})`}
        </div></Description>
        <Description term="当前状态">{originalVoucher.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const OriginalVoucherBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default OriginalVoucherBase



