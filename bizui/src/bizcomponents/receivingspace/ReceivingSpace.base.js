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


const menuData = {menuName:"收货区", menuFor: "receivingSpace",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  location: '位置',
  contactNumber: '联系电话',
  description: '描述',
  totalArea: '总面积',
  warehouse: '仓库',
  latitude: '纬度',
  longitude: '经度',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'receivingSpace') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({receivingSpace,targetComponent})=>{

	
	
	const {ReceivingSpaceService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{receivingSpace.id}</Description> 
<Description term="位置">{receivingSpace.location}</Description> 
<Description term="联系电话">{receivingSpace.contactNumber}</Description> 
<Description term="描述">{receivingSpace.description}</Description> 
<Description term="总面积">{receivingSpace.totalArea}</Description> 
<Description term="仓库">{receivingSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${receivingSpace.warehouse.displayName}(${receivingSpace.warehouse.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"仓库","warehouse",ReceivingSpaceService.requestCandidateWarehouse,
	      ReceivingSpaceService.transferToAnotherWarehouse,"anotherWarehouseId",receivingSpace.warehouse?receivingSpace.warehouse.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="纬度">{receivingSpace.latitude}</Description> 
<Description term="经度">{receivingSpace.longitude}</Description> 
<Description term="最后更新时间">{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(receivingSpace,targetComponent)}
      </DescriptionList>
	)

}
	



const ReceivingSpaceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ReceivingSpaceBase



