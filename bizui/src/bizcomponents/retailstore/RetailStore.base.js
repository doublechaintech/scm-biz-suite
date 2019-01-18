
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"双链小超", menuFor: "retailStore",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountSetList', displayName:'账套', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
  		],
}

const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 

}

const displayColumns = [
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStore') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '电话', debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '业主', debugtype: 'string', dataIndex: 'owner', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '双链小超全国运营中心', dataIndex: 'retailStoreCountryCenter', render: (text, record) => renderReferenceCell(text, record)},
  { title: '城市服务中心', dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record)},
  { title: '创建', dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '招商', dataIndex: 'investmentInvitation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '加盟', dataIndex: 'franchising', render: (text, record) => renderReferenceCell(text, record)},
  { title: '装修', dataIndex: 'decoration', render: (text, record) => renderReferenceCell(text, record)},
  { title: '开业', dataIndex: 'opening', render: (text, record) => renderReferenceCell(text, record)},
  { title: '关闭', dataIndex: 'closing', render: (text, record) => renderReferenceCell(text, record)},
  { title: '成立', dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record) },
  { title: '纬度', debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '经度', debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '描述', debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record) },
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '22',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  telephone: '电话',
  owner: '业主',
  retailStoreCountryCenter: '双链小超全国运营中心',
  cityServiceCenter: '城市服务中心',
  creation: '创建',
  investmentInvitation: '招商',
  franchising: '加盟',
  decoration: '装修',
  opening: '开业',
  closing: '关闭',
  founded: '成立',
  latitude: '纬度',
  longitude: '经度',
  description: '描述',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}


const RetailStoreBase={menuData,displayColumns,fieldLabels,displayColumns}
export default RetailStoreBase



