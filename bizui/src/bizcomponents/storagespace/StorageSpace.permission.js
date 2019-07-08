

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './StorageSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (storageSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{storageSpace.id}</Description> 
<Description term="Location">{storageSpace.location}</Description> 
<Description term="Contact Number">{storageSpace.contactNumber}</Description> 
<Description term="Total Area">{storageSpace.totalArea}</Description> 
<Description term="Latitude">{storageSpace.latitude}</Description> 
<Description term="Longitude">{storageSpace.longitude}</Description> 
<Description term="Last Update Time">{ moment(storageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = storageSpace => {
  const {StorageSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={storageSpace}  targetObjectMeta={StorageSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class StorageSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  storageSpace = this.props.storageSpace;
    const { id,displayName, goodsShelfCount } = storageSpace
    const cardsData = {cardsName:"Storage Space",cardsFor: "storageSpace",cardsSource: storageSpace,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  storageSpace: state._storageSpace,
}))(Form.create()(StorageSpacePermission))

