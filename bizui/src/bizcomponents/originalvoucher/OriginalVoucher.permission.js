

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
import styles from './OriginalVoucher.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (originalVoucher,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{originalVoucher.id}</Description> 
<Description term="头衔">{originalVoucher.title}</Description> 
<Description term="由">{originalVoucher.madeBy}</Description> 
<Description term="受">{originalVoucher.receivedBy}</Description> 
<Description term="凭证类型">{originalVoucher.voucherType}</Description> 
<Description term="当前状态">{originalVoucher.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = originalVoucher => {
  const {OriginalVoucherBase} = GlobalComponents
  return <PermissionSetting targetObject={originalVoucher}  targetObjectMeta={OriginalVoucherBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OriginalVoucherPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  originalVoucher = this.props.originalVoucher;
    const { id,displayName,  } = originalVoucher
    const cardsData = {cardsName:"原始凭证",cardsFor: "originalVoucher",cardsSource: originalVoucher,
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
  originalVoucher: state._originalVoucher,
}))(Form.create()(OriginalVoucherPermission))

