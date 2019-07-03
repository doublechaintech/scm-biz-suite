

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
import styles from './OriginalVoucherAuditing.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (originalVoucherAuditing,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{originalVoucherAuditing.id}</Description> 
<Description term="谁">{originalVoucherAuditing.who}</Description> 
<Description term="评论">{originalVoucherAuditing.comments}</Description> 
<Description term="制造日期">{ moment(originalVoucherAuditing.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = originalVoucherAuditing => {
  const {OriginalVoucherAuditingBase} = GlobalComponents
  return <PermissionSetting targetObject={originalVoucherAuditing}  targetObjectMeta={OriginalVoucherAuditingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OriginalVoucherAuditingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  originalVoucherAuditing = this.props.originalVoucherAuditing;
    const { id,displayName, originalVoucherCount } = originalVoucherAuditing
    const cardsData = {cardsName:"原始凭证的审核",cardsFor: "originalVoucherAuditing",cardsSource: originalVoucherAuditing,
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
  originalVoucherAuditing: state._originalVoucherAuditing,
}))(Form.create()(OriginalVoucherAuditingPermission))

